package nc.ui.so.qs.mmplanbill.rd2pmo.action;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import nc.bs.framework.common.NCLocator;
import nc.itf.so.qs.sc.planbill.service.IRdMmService;
import nc.ui.pubapp.uif2app.model.BillManageModel;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.uitheme.ui.ThemeResourceCenter;
import nc.util.mmf.framework.base.MMValueCheck;
import nc.vo.pub.BusinessException;
import nc.vo.so.qs.sc.RdPorductDetailVO;

public class RdReturnAction extends NCAction{
	
	private final String iconurl="themeres/ui/toolbaricons/cancel.png";
	private BillManageModel model;
	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
		this.model.addAppEventListener(this);
	}

	public RdReturnAction(){
		
		this.setBtnName("ȡ��");
		this.setCode("ReRPMO");
		this.putValue("ShortDescription", "ȡ��ѡ��Ĵ�������Ϣ���ظ���ʼ��״̬��");
		this.putValue("SmallIcon", ThemeResourceCenter.getInstance().getImage(iconurl));
		this.setEnabled(false);
		
	}


	private IRdMmService rdservice;
	
	
	
	public IRdMmService getRdservice() {
		
		if(this.rdservice==null){
			this.rdservice=NCLocator.getInstance().lookup(IRdMmService.class);
		}
		
		return rdservice;
	}
	
	
	

	@Override
	public void doAction(ActionEvent e) throws Exception {
		// TODO �Զ����ɵķ������
		
		try{
			 
			 Object[] objs = getModel().getSelectedOperaDatas();
				
			 if ((null == objs) || (MMValueCheck.isEmpty(objs))) {
				throw new BusinessException("û��ѡ���κ����ݣ�����ʧ�ܣ�") ;
			 }
			 
			 List<RdPorductDetailVO> rds=new ArrayList();
			 
			 for(Object obj:objs){
				 
				 if(obj instanceof RdPorductDetailVO){
					 
					 rds.add((RdPorductDetailVO) obj);
					 
					 
				 }else{
					 throw new BusinessException("�������Ͳ���ȷ������ʧ��");
				 }
				 
				 
			 }
			 

			 RdPorductDetailVO[] rdvo=rds.toArray(new RdPorductDetailVO[rds.size()]);

			 RdPorductDetailVO[] retobj=this.getRdservice().DoRePMO(rdvo);
			 
			 this.getModel().directlyDelete(retobj);
			 
			 ShowStatusBarMsgUtil.showStatusBarMsg("���ȵ���ϸ�ɹ��˻أ�", this.getModel().getContext());
				 
	

		 }catch(Exception ex){
			 
			 ShowStatusBarMsgUtil.showErrorMsg("����", ex.getMessage(), this.getModel().getContext());
			 
			 throw new BusinessException(ex);
		 }
		
		
	}
	
	@Override
	protected boolean isActionEnable() {
		// TODO �Զ����ɵķ������
		
		RdPorductDetailVO selectvo=(RdPorductDetailVO)this.getModel().getSelectedData();
		
		if(selectvo!=null && selectvo.getBillstatus()==2){
			return true;
		}else{
			return false;
		}
		
	}

}
