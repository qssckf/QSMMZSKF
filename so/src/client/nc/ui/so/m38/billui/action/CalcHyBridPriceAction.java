package nc.ui.so.m38.billui.action;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import nc.bs.framework.common.NCLocator;
import nc.itf.org.IOrgUnitQryService;
import nc.itf.scmpub.reference.uap.para.SysParaInitQuery;
import nc.itf.so.qs.sc.planbill.service.IPlanBillSerive;
import nc.ui.pub.beans.progress.IProgressMonitor;
import nc.ui.pub.beans.progress.NCProgresses;
import nc.ui.pubapp.uif2app.query2.action.QueryExecutor;
import nc.ui.so.m38.billui.view.PreOrderEditor;
import nc.ui.so.pub.keyvalue.CardKeyValue;
import nc.ui.uif2.IExceptionHandler;
import nc.ui.uif2.NCAsynAction;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.ui.uif2.ToftPanelAdaptor;
import nc.ui.uif2.components.progress.TPAProgressUtil;
import nc.ui.uif2.editor.IEditor;
import nc.ui.uif2.model.AbstractAppModel;
import nc.vo.org.OrgVO;
import nc.vo.pub.BusinessException;
import nc.vo.pub.lang.UFDouble;
import nc.vo.pub.para.SysInitVO;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
import nc.vo.pubapp.pattern.pub.PubAppTool;
import nc.vo.so.m38.entity.PreOrderBVO;
import nc.vo.so.m38.entity.PreOrderVO;
import nc.vo.so.pub.keyvalue.IKeyValue;

public class CalcHyBridPriceAction extends NCAsynAction{

	private AbstractAppModel model;
	private PreOrderEditor editor;
	private String pk_org;
	private Set<String> defcus;
	private String initcus;
	private String billcus;
	private UFDouble defratio;
	private UFDouble deftax;
	private Set<String> matpk;
	private IProgressMonitor progressMonitor = null;
	private IPlanBillSerive PlanService;
	private boolean isTPAMonitor = true;
	private TPAProgressUtil tpaProgressUtil;
	
	public IPlanBillSerive getPlanService() {
		
		if(this.PlanService==null){
			this.PlanService=NCLocator.getInstance().lookup(IPlanBillSerive.class);
		}
		return PlanService;
	}
	
	public String getBillcus() {
		return billcus;
	}

	public void setBillcus(String billcus) {
		this.billcus = billcus;
	}

	public String getInitcus() {
		return initcus;
	}



	public void setInitcus(String initcus) {
		this.initcus = initcus;
	}
	
	public Set<String> getMatpk() {
		
		if(this.matpk==null){
			this.matpk=new HashSet();
		}
		
		return matpk;
	}

	public void setMatpk(Set<String> matpk) {
		this.matpk = matpk;
	}

	public Set<String> getDefcus() {
		
		if(this.defcus==null){
			this.defcus=new HashSet();
		}
		
		return defcus;
	}

	public void setDefcus(Set<String> defcus) {
		this.defcus = defcus;
	}

	public UFDouble getDefratio() {
		return defratio;
	}

	public void setDefratio(UFDouble defratio) {
		this.defratio = defratio;
	}

	public UFDouble getDeftax() {
		return deftax;
	}

	public void setDeftax(UFDouble deftax) {
		this.deftax = deftax;
	}
	
	public String getPk_org() {
		return pk_org;
	}

	public void setPk_org(String pk_org) {
		this.pk_org = pk_org;
	}
	
	public CalcHyBridPriceAction(){
		
		this.setBtnName("�������ϼ�");
		this.setCode("CalcHyBridPrice");
		
	}
	
	public AbstractAppModel getModel() {
		return model;
	}

	public void setModel(AbstractAppModel model) {
		this.model = model;
		this.model.addAppEventListener(this);
	}

	public PreOrderEditor getEditor() {
		return editor;
	}

	public void setEditor(PreOrderEditor editor) {
		this.editor = editor;
	}

	public boolean isTPAMonitor() {
		return (this.isTPAMonitor) && (getModel() != null) && ((getTpaProgressUtil().getContext().getEntranceUI() instanceof ToftPanelAdaptor));
	}
	
	public TPAProgressUtil getTpaProgressUtil() {
	  if ((this.tpaProgressUtil == null) && (this.isTPAMonitor)) {
	    this.tpaProgressUtil = new TPAProgressUtil();
	    this.tpaProgressUtil.setContext(getModel().getContext());
	  }
	  
	  return this.tpaProgressUtil;
	}
	
	@Override
	public boolean beforeStartDoAction(ActionEvent event) throws Exception {
		// TODO �Զ����ɵķ������
		
		if ((this.progressMonitor != null) && (!this.progressMonitor.isDone())) {
			return false;
		}
		
		this.progressMonitor = (this.isTPAMonitor() ? this.getTpaProgressUtil().getTPAProgressMonitor() : NCProgresses.createDialogProgressMonitor(null));
		
		String name = "���ڼ������ϼ�";
		
		this.progressMonitor.beginTask(name, -1);
		this.progressMonitor.setProcessInfo(name);
		
		IOrgUnitQryService orgservice=NCLocator.getInstance().lookup(IOrgUnitQryService.class);
		
		this.getDefcus().clear();
		this.getMatpk().clear();
		
		
		StringBuilder errMsg = new StringBuilder("��������Ч��ʧ��!"+"\n");
		
		IKeyValue keyValue = new CardKeyValue(this.editor.getBillCardPanel());
		
		String pk_customer=keyValue.getHeadStringValue("vdef1");
		
		String pk_org=keyValue.getHeadStringValue("pk_org");
		
		

		this.setPk_org(pk_org);
		
		List errlist=new ArrayList();
		
		if (PubAppTool.isNull(pk_org)) {
			
			throw new BusinessException("����ѡ����֯�ٽ��м��㣡");

		}
		
		if (PubAppTool.isNull(pk_customer)) {
			
			throw new BusinessException("����ѡ���ն˿ͻ��ٽ��м��㣡");

		}else{
			
			this.getDefcus().add(pk_customer);
			this.setBillcus(pk_customer);
			
		}
		
		OrgVO org=orgservice.getOrg(pk_org);
		
		SysInitVO defcus=SysParaInitQuery.queryByParaCode(this.getPk_org(), "SO66");
		
		SysInitVO defratio=SysParaInitQuery.queryByParaCode(this.getPk_org(), "SO68");
		
		SysInitVO deftax=SysParaInitQuery.queryByParaCode(this.getPk_org(), "SO70");
		
		if(defcus==null || defratio==null || deftax==null){
			throw new BusinessException("������֯��("+org.getCode()+")"+org.getName()+"���Ƿ���SO66/SO68/SO70����");
		}
		
		if(defcus.getValue()!=null){
			this.getDefcus().add(defcus.getValue());
			this.setInitcus(defcus.getValue());
		}
		
		if(defratio.getValue()==null){
			throw new BusinessException("��֯��("+org.getCode()+")"+org.getName()+"��û��ά��SO68����ֵ��������ɼ��㣡");
		}else{
			this.setDefratio(new UFDouble(defratio.getValue()));
		}
		
		if(deftax.getValue()==null){
			throw new BusinessException("��֯��("+org.getCode()+")"+org.getName()+"��û��ά��SO70����ֵ��������ɼ��㣡");
		}else{
			this.setDeftax(new UFDouble(deftax.getValue()));
		}
		
		
		int row=this.getEditor().getBillCardPanel().getRowCount();
		
		if(row==0){
			throw new BusinessException("����û���κμ�¼�����ܽ��м��㣡");
		}
		
		for(int i=0;i<row;i++){
			
			String mat=keyValue.getBodyStringValue(i, "cmaterialvid");
			String bomid=keyValue.getBodyStringValue(i, "vbdef12");
			UFDouble nnum=keyValue.getBodyUFDoubleValue(i, "nnum");
			
			if(PubAppTool.isNull(mat) || PubAppTool.isNull(bomid) || nnum==null){
				
				errlist.add(i);
				
				errMsg.append("������Ϣ��").append("��"+(i+1)+"�У����ϡ�BOM������������Ϊ�գ����ܽ��м��㣡").append("\n");
				
			}else{
				
				this.getMatpk().add(mat+"#"+bomid);
				
			}
		}
		
		if(errlist.size()>0){
			throw new BusinessException(errMsg.toString());
		}
		
		return true;
	}
	
	
	

	@Override
	public boolean doAfterFailure(ActionEvent arg0, Throwable arg1) {
		// TODO �Զ����ɵķ������
		
		if (this.progressMonitor != null) {
			this.progressMonitor.done();
			this.progressMonitor = null;
		}
		
		return true;
	}

	@Override
	public void doAfterSuccess(ActionEvent arg0) {
		// TODO �Զ����ɵķ������
		if (this.progressMonitor != null) {
			this.progressMonitor.done();
			this.progressMonitor = null;
		}
		
	}

	@Override
	public void doAction(ActionEvent event) throws Exception {
		// TODO �Զ����ɵķ������
		
	
		Map<String,Map<String,UFDouble>> bominfomap=this.getPlanService().querBominfoByHybridPrice(this.getPk_org(), this.getMatpk());
		Map<String,Map<String,UFDouble>> cusmap = this.getPlanService().querCusPriceByHybridPrice(this.getPk_org(), this.getDefcus());
		
		IKeyValue keyValue = new CardKeyValue(this.editor.getBillCardPanel());
		int row=this.getEditor().getBillCardPanel().getRowCount();
		
		Map<String,UFDouble> cusdjmap=new HashMap();
		
		if(cusmap.containsKey(this.getBillcus())){
			cusdjmap=cusmap.get(this.getBillcus());
		}else{
			cusdjmap=cusmap.get(this.getInitcus());
		}
		
		
		for(int i=0;i<row;i++){
			
			String mat=keyValue.getBodyStringValue(i, "cmaterialvid");
			String bomid=keyValue.getBodyStringValue(i, "vbdef12");
			UFDouble nnum=keyValue.getBodyUFDoubleValue(i, "nnum");
			
			String key=mat+"#"+bomid;
			List<String> memo=new ArrayList();
			
			UFDouble o=this.getDefratio().multiply(this.getDeftax()).add(1);
			String Oformula="(1+"+this.getDefratio()+"%*"+this.getDeftax()+")";
			
			if(bominfomap.containsKey(key)){
				
				Map<String,UFDouble> NumMap=bominfomap.get(key);
				
				UFDouble p=UFDouble.ZERO_DBL;
				
				for(String hhfl:NumMap.keySet()){
					
					if(cusdjmap.containsKey(hhfl)){
						
						p=p.add(NumMap.get(hhfl).multiply(cusdjmap.get(hhfl)).multiply(nnum));
						
						String formula="[Num]"+nnum+"*[HfPrice]"+NumMap.get(hhfl)+"*[CusDj]"+cusdjmap.get(hhfl);
						
						memo.add(formula);
						
					}else{
						
						p=p.add(NumMap.get(hhfl).multiply(UFDouble.ZERO_DBL).multiply(nnum));
						
						String formula="[Num]"+nnum+"*[HfPrice]"+NumMap.get(hhfl)+"*[CusDj]0";
						
						memo.add(formula);
						
					}
					
				}
				
				UFDouble hfprice=p.multiply(o);
				
				String[] formulas=memo.toArray(new String[memo.size()]);
				
				String hfformula="";
				
				for(int i1=0;i1<formulas.length;i1++){
					
					if(i1==0){
						
						hfformula=hfformula+formulas[i1];
						
					}else{
						
						hfformula=hfformula+"+"+formulas[i1];
					}
				}
				
				keyValue.setBodyValue(i,"vbdef13", hfprice);
				keyValue.setBodyValue(i,"vbdef14", "("+hfformula+")*"+Oformula);
				
				
			}else{
				
				keyValue.setBodyValue(i,"vbdef13", 0);
				keyValue.setBodyValue(i,"vbdef14", "����BOM��Ϣû���ҵ�ƥ��Ļ������Ϣ");
				
			}
			
			
		}
		
		ShowStatusBarMsgUtil.showStatusBarMsg("�������ϼ���ϣ�", this.getModel().getContext());
		
		
	}

}
