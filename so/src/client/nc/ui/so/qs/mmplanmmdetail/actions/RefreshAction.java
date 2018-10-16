package nc.ui.so.qs.mmplanmmdetail.actions;

import java.awt.event.ActionEvent;
import java.util.Collection;

import nc.bs.framework.common.NCLocator;
import nc.itf.so.qs.sc.planbill.service.IPlanBillSerive;
import nc.md.persist.framework.IMDPersistenceQueryService;
import nc.md.persist.framework.MDPersistenceService;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.model.BillManageModel;
import nc.uitheme.ui.ThemeResourceCenter;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.so.qs.sc.MmPlanBillVO;
import nc.vo.so.qs.sc.PlanProduceDetailVO;
import nc.vo.so.qs.sc.RdPorductDetailVO;

public class RefreshAction extends NCAction{
	
	private final String iconurl="themeres/ui/toolbaricons/refresh_highlight.png";
	private BillManageModel model = null;
	private BillManageModel fmodel = null;
	private IPlanBillSerive PlanService;
	
	private IMDPersistenceQueryService getMDQueryService() {
		return MDPersistenceService.lookupPersistenceQueryService();
	}
	
	public IPlanBillSerive getPlanService() {
		
		if(this.PlanService==null){
			this.PlanService=NCLocator.getInstance().lookup(IPlanBillSerive.class);
		}
		return PlanService;
	}
	
	public RefreshAction(){
		this.setBtnName("ˢ��");
		this.setCode("DetailRefreshB");
		this.putValue("ShortDescription", "����ѡ��ĵ��ȵ�չ����¼����ˢ���Ų���Ϣ");
		this.putValue("SmallIcon", ThemeResourceCenter.getInstance().getImage(iconurl));
		this.setEnabled(false);
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
		
		PlanProduceDetailVO vo=(PlanProduceDetailVO)this.getFmodel().getSelectedData();
		
		if(vo!=null){
			
			String pk_planbill=vo.getPk_planbill_b();

			Collection<RdPorductDetailVO> col=this.getMDQueryService().queryBillOfVOByCond(RdPorductDetailVO.class,"vsrcplanbid='"+pk_planbill+"'",false);
			
			RdPorductDetailVO[] plandetails=col.toArray(new RdPorductDetailVO[col.size()]);
			
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
