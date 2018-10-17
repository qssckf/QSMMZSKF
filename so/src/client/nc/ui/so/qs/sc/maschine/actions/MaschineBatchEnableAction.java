package nc.ui.so.qs.sc.maschine.actions;

import nc.bs.bd.service.ValueObjWithErrLog;
import nc.ui.bd.pub.actions.BDBatchEnableAction;
//import nc.ui.so.xlx.tran.driver.service.DriverAppModelService;
import nc.ui.so.qs.sc.maschine.service.MaschineMaintainService;
import nc.ui.uif2.UIState;
import nc.ui.uif2.model.BillManageModel;
import nc.vo.pub.SuperVO;
import nc.vo.so.qs.sc.AggMaschineVO;
import nc.vo.so.qs.sc.MaschineVO;
//import nc.vo.so.xlx.tran.DriverVO;

public class MaschineBatchEnableAction extends BDBatchEnableAction {
	
	private String StatusField=null;
	private String StatusValue=null;

	public String getStatusField() {
		return StatusField;
	}

	public void setStatusField(String statusField) {
		StatusField = statusField;
	}

	public String getStatusValue() {
		return StatusValue;
	}

	public void setStatusValue(String statusValue) {
		StatusValue = statusValue;
	}
	
	public MaschineBatchEnableAction(){
		this.setStatusField("mstatus");
		this.setStatusValue("1");
	}

	@Override
	public ValueObjWithErrLog doEnable(SuperVO[] vos)
			throws Exception {
		// TODO 自动生成的方法存根
		MaschineVO[] vmaschineVOs=new MaschineVO[vos.length];
		
		for (int i = 0; i < vos.length; i++) {
			
			if(vos[i] instanceof MaschineVO){
				vmaschineVOs[i]=(MaschineVO) vos[i];
			}
			
		}
		
		
		return this.getService().enableMaschineVO(vmaschineVOs);
	}
	
	public MaschineMaintainService getService() {
		
		MaschineMaintainService service=(MaschineMaintainService)((BillManageModel)getModel()).getService();
		return service;
	}

	@Override
	protected boolean isEnabled(SuperVO vo) {
		// TODO 自动生成的方法存根
		if (vo != null) {
			String status=(String) vo.getAttributeValue(this.getStatusField());
			if((status !=null) && "1".equals(status)){
				return true;
			}
		}
		return false;
	}
	

}
