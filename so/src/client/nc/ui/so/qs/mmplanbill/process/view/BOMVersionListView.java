package nc.ui.so.qs.mmplanbill.process.view;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.ListSelectionModel;

import nc.bs.framework.common.NCLocator;
import nc.bs.logging.Logger;
import nc.itf.so.qs.sc.planbill.service.IPlanBillSerive;
import nc.ui.dcm.chnlrplstrct.maintain.action.MessageDialog;
import nc.ui.ml.NCLangRes;
import nc.ui.pub.bill.BillItem;
import nc.ui.pub.bill.BillItemHyperlinkEvent;
import nc.ui.pub.bill.BillItemHyperlinkListener;
import nc.ui.pub.bill.BillListPanel;
import nc.ui.pub.bill.BillModel;
import nc.ui.pub.bill.IBillModelRowStateChangeEventListener;
import nc.ui.pub.bill.RowStateChangeEvent;
import nc.ui.pub.bill.table.BillTableBooleanCellRenderer;
import nc.ui.pubapp.uif2app.view.ShowUpableBillListView;
import nc.ui.pubapp.uif2app.view.value.BillListViewMetaDataFullValueAdapter;
import nc.ui.so.qs.mmplanbill.process.model.BomChildAppModel;
import nc.ui.so.qs.mmplanbill.process.model.QsVOBillListPanelValueSetter;
import nc.ui.uif2.IExceptionHandler;
import nc.ui.uif2.UIState;
import nc.ui.uif2.editor.BillListView;
import nc.ui.uif2.editor.BillListView.VOBillListPanelValueSetter;
import nc.vo.pub.AggregatedValueObject;
import nc.vo.pub.BusinessException;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.ExtendedAggregatedValueObject;
import nc.vo.pub.SuperVO;
import nc.vo.pub.lang.UFBoolean;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.trade.pub.IExAggVO;

public class BOMVersionListView extends ShowUpableBillListView implements ListSelectionListener{

	public int selectIndex = 0;
	private BomVersionTableCellRenderer cellRenderer;
	private Boolean IsChange;
	private BomChildAppModel BomModel;
	private IPlanBillSerive PlanService;
	private nc.ui.uif2.editor.BillForm card;
	private Boolean IsFrist;
	
	
	public nc.ui.uif2.editor.BillForm getCard() {
		return card;
	}

	public void setCard(nc.ui.uif2.editor.BillForm card) {
		this.card = card;
	}

	
	public IPlanBillSerive getPlanService() {
		
		if(this.PlanService==null){
			this.PlanService=NCLocator.getInstance().lookup(IPlanBillSerive.class);
		}
		return PlanService;
	}
	
	
	public BomChildAppModel getBomModel() {
		return BomModel;
	}

	public void setBomModel(BomChildAppModel bomModel) {
		BomModel = bomModel;
	}

	public BOMVersionListView(){
		setBillListPanelValueSetter(new QsVOBillListPanelValueSetter());
	}

	@Override
	public void initUI() {
		// TODO �Զ����ɵķ������
		super.initUI();
		
		this.IsFrist=true;
		
		BillListPanel billlist = this.getBillListPanel();
		
		//����������Ŀ�����Ӳ����¼�
		billlist.getHeadItem("Opera").addBillItemHyperlinkListener(new BillItemHyperlinkListener(){

			@Override
			public void hyperlink(BillItemHyperlinkEvent event) {
				// TODO �Զ����ɵķ������
				
				if(UIState.EDIT.equals(BOMVersionListView.this.getCard().getModel().getUiState())){
					
					UFBoolean sfexec=new UFBoolean(BOMVersionListView.this.getCard().getBillCardPanel().getHeadItem("sfexand").getValue());
					
					if(UFBoolean.TRUE.equals(sfexec)){
						
						MessageDialog.showErrorDlg(BOMVersionListView.this, "����", "�������ȵ��Ѿ�ִ��չ��������ѡ��");
						
					}else{
						
						String bomid = (String) getBillListPanel().getParentListPanel().getTableModel().getValueAt(event.getRow(), "cbomid");
						String bomversion=(String) getBillListPanel().getParentListPanel().getTableModel().getValueAt(event.getRow(), "BomVersion");
						
						BOMVersionListView.this.getCard().getBillCardPanel().getHeadItem("bomid").setValue(bomid);
						BOMVersionListView.this.getCard().getBillCardPanel().getHeadItem("vbomversion").setValue(bomversion);
						
					}
					
			
				}else{
					MessageDialog.showErrorDlg(BOMVersionListView.this, "����", "�������ȵ���Ϊ���޸ġ�״̬������ѡ��");
				}
			}
			
		});
		
		
		initCellRenderer(this.billListPanel);
		
		getBillListPanel().getParentListPanel().getTable().getSelectionModel().addListSelectionListener(this);
				
	}
	
	private void initCellRenderer(BillListPanel panel)
	{
	   TableColumnModel columnModel = panel.getHeadTable().getColumnModel();
	   for (int i = 0; i < columnModel.getColumnCount(); i++) {
	     TableColumn column = columnModel.getColumn(i);
	     
	     if (!(column.getCellRenderer() instanceof BillTableBooleanCellRenderer))
	     {
	
	       column.setCellRenderer(getCellRenderer());
	     }
	   }
	}
	
	private BomVersionTableCellRenderer getCellRenderer()
	{
	     if (this.cellRenderer == null) {
	       this.cellRenderer = new BomVersionTableCellRenderer(this.billListPanel.getHeadBillModel(), false);
	     }
	     
	     return this.cellRenderer;
	}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO �Զ����ɵķ������
		
		
		 if (!e.getValueIsAdjusting()) {
			 int headRow = ((ListSelectionModel)e.getSource()).getAnchorSelectionIndex();
			 
			 if(headRow==this.selectIndex && !this.IsFrist){
				 this.IsChange=false;
			 }else{
				 
				 if(this.IsFrist){
					 
					 this.IsFrist=false;
					 
				 }

				 this.IsChange=true;
				 
			 }
			 
			 this.selectIndex = headRow;
			 getCellRenderer().setCurrentRow(headRow);
			 if (headRow >= 0) {
				 headRowChange(headRow);
				 
				 if(IsChange){
					 try{
						 SetBomChildInfo(headRow);
					 }catch(Exception ex){
						 ExceptionUtils.wrappException(ex);
					 }
					 
				 }
				 
			 }
		 }

	}

	private void SetBomChildInfo(int headRow) throws BusinessException {
		// TODO �Զ����ɵķ������
		
		String bomid = (String) getBillListPanel().getParentListPanel().getTableModel().getValueAt(headRow, "cbomid");
		String pk_org=(String) getBillListPanel().getParentListPanel().getTableModel().getValueAt(headRow, "pk_org");
		
		SuperVO[] bomChVos=this.getPlanService().queryBomChildren(bomid, pk_org);
		
		
		if(bomChVos!=null && bomChVos.length>0){
			this.getBomModel().initModel(bomChVos);
		}
		
		
		
	}

	private void headRowChange(int headRow) {
		// TODO �Զ����ɵķ������
		
		int state = getBillListPanel().getParentListPanel().getTableModel().getRowState(headRow);
		   
		getBillListPanel().repaint();
		if (state == -1) {
		     getBillListPanel().getChildListPanel().cancelSelectAllTableRow();
		     getBillListPanel().updateUI();
		}
		
		
		
	}
		

	

}
