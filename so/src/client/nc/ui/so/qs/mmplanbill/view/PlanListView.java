package nc.ui.so.qs.mmplanbill.view;

import nc.bs.framework.common.NCLocator;
import nc.funcnode.ui.FuncletInitData;
import nc.funcnode.ui.FuncletWindowLauncher;
import nc.itf.so.qs.sc.planbill.service.IPlanBillSerive;
import nc.ui.ebpur.purproject.view.ReleaseSuppItemFormView;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.pub.bill.BillItemHyperlinkEvent;
import nc.ui.pub.bill.BillItemHyperlinkListener;
import nc.ui.pub.bill.BillListPanel;
import nc.ui.pubapp.uif2app.view.ShowUpableBillListView;
import nc.ui.sm.power.FuncRegisterCacheAccessor;
import nc.ui.so.qs.mmplanbill.process.model.PlanBillProcessPara;
import nc.ui.so.qs.pub.tools.ScreenTools;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.vo.pub.BusinessException;
import nc.vo.sm.funcreg.FuncRegisterVO;
import nc.vo.so.qs.sc.MmPlanBillVO;

public class PlanListView extends ShowUpableBillListView {

	private IPlanBillSerive PlanService;
	
	public IPlanBillSerive getPlanService() {
		
		if(this.PlanService==null){
			this.PlanService=NCLocator.getInstance().lookup(IPlanBillSerive.class);
		}
		return PlanService;
	}
	
	


	@Override
	public void initUI() {
		// TODO �Զ����ɵķ������
		super.initUI();
		
		BillListPanel billlist = this.getBillListPanel();
		
		//����������Ŀ�����Ӳ����¼�
		billlist.getHeadItem("handleReply").addBillItemHyperlinkListener(new BillItemHyperlinkListener(){

			@Override
			public void hyperlink(BillItemHyperlinkEvent event) {
				// TODO �Զ����ɵķ������
				
				FuncRegisterVO frVO = FuncRegisterCacheAccessor.getInstance().getFuncRegisterVOByFunCode("4006200202");
				
				if(frVO!=null){
					
					FuncletInitData funInitData = new FuncletInitData();
					
					PlanBillProcessPara initdata=new PlanBillProcessPara();
					
					MmPlanBillVO selectVo=(MmPlanBillVO) PlanListView.this.getModel().getSelectedData();
					
					if(selectVo==null){
						
						ShowStatusBarMsgUtil.showErrorMsg("����", "û�еõ����������!", PlanListView.this.getModel().getContext());
						
						return;
					}
					
					try {
						if(PlanListView.this.getPlanService().QueryPlanBillIsExists(selectVo.getPk_planbill())){
							
							initdata.setVoStatus(1);
							selectVo.setStatus(1);
							
						}else{
							
							initdata.setVoStatus(2);
							selectVo.setStatus(2);
							
						}
					} catch (BusinessException e) {
						// TODO �Զ����ɵ� catch ��
						
						ShowStatusBarMsgUtil.showErrorMsg("����",e.getMessage(), PlanListView.this.getModel().getContext());
						
						return;
						
					}
					
					initdata.setPlanVo(selectVo);
					
					Boolean sf=selectVo.getSfexand().booleanValue();
					
					if(sf){
						initdata.setEdited(false);
					}else{
						initdata.setEdited(true);
					}
					
					initdata.setModel(PlanListView.this.getModel());
					
					initdata.setList(PlanListView.this);
					
					funInitData.setInitData(initdata);	
					
					int w = 680;
					int h = 680;
					if ((ScreenTools.getScreen().width == 1024) && (ScreenTools.getScreen().height == 768))
					{
						w = 780;
					}
					
					FuncletWindowLauncher.openFuncNodeDialog(PlanListView.this.getModel().getContext().getEntranceUI(), frVO, funInitData, null, true, false, ScreenTools.newDimension(w, h));
					
				}else{
					
					ShowStatusBarMsgUtil.showErrorMsg("����", "û���ҵ�ҵ����Ĺ��ܽڵ�", PlanListView.this.getModel().getContext());
					
					return;
					
				}
				
			}
			
		});
		
		
		
		
		
	}
	
	

}
