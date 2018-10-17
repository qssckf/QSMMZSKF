package nc.ui.so.qs.mmplandetail.actions;

import java.awt.event.ActionEvent;

import nc.bs.framework.common.NCLocator;
import nc.itf.so.qs.sc.planbill.service.IPlanBillSerive;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.model.BillManageModel;
import nc.uitheme.ui.ThemeResourceCenter;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.so.qs.sc.MmPlanBillVO;

public class RefreshAction extends NCAction{
	
	private final String iconurl="themeres/ui/toolbaricons/refresh_highlight.png";
	private BillManageModel model = null;
	private BillManageModel fmodel = null;
	private IPlanBillSerive PlanService;
	

	public IPlanBillSerive getPlanService() {
		
		if(this.PlanService==null){
			this.PlanService=NCLocator.getInstance().lookup(IPlanBillSerive.class);
		}
		return PlanService;
	}
	
	public RefreshAction(){
		this.setBtnName("ˢ��");
		this.setCode("DetailRefresh");
		this.putValue("ShortDescription", "����ѡ��ĵ��ȵ���¼����ˢ��չ����Ϣ");
		this.putValue("SmallIcon", ThemeResourceCenter.getInstance().getImage(iconurl));
	}

	public BillManageModel getFmodel() {
		return fmodel;
	}

	public void setFmodel(BillManageModel fmodel) {
		this.fmodel = fmodel;
		this.fmodel.addAppEventListener(this);
	}

	public BillManageModel getModel() {
		return model;
	}

	public void setModel(BillManageModel model) {
		this.model = model;
		this.model.addAppEventListener(this);
	}
	
	@Override
	public void doAction(ActionEvent e) throws Exception {
		// TODO �Զ����ɵķ������
		
		MmPlanBillVO vo=(MmPlanBillVO)this.getFmodel().getSelectedData();
		
		if(vo!=null){
			
			String pk_planbill=vo.getPk_planbill();
			
			SuperVO[] plandetails=this.getPlanService().quyerPlanDetailVOs("pk_planbill='"+pk_planbill+"'");
			
			if(plandetails!=null && plandetails.length>0){
				this.getModel().initModel(plandetails);
			}else{
				this.getModel().initModel(null);
			}
			
			
			
		}else{
			throw new BusinessException("û��ѡ���κμ�¼���������ˢ�²�����");
		}
		
		
		
	}

	@Override
	protected boolean isActionEnable() {
		// TODO �Զ����ɵķ������
		return this.getFmodel().getSelectedData()==null?false:true;
	}
	
	

}
