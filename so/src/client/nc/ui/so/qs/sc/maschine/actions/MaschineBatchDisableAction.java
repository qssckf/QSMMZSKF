package nc.ui.so.qs.sc.maschine.actions;

import nc.bs.bd.service.ValueObjWithErrLog;
import nc.bs.uif2.BusinessExceptionAdapter;
//import nc.ui.so.xlx.tran.driver.service.DriverAppModelService;
import nc.ui.so.qs.sc.action.batch.BDBatchDisableAction;
import nc.ui.so.qs.sc.maschine.service.MaschineMaintainService;
import nc.ui.uif2.IShowMsgConstant;
import nc.ui.uif2.model.BillManageModel;
//import nc.ui.xlx.action.batch.BDBatchDisableAction;
import nc.vo.ml.NCLangRes4VoTransl;
import nc.vo.pub.SuperVO;
//import nc.vo.so.xlx.tran.DriverVO;
import nc.vo.so.qs.sc.MaschineVO;
import nc.vo.util.ManageModeUtil;

public class MaschineBatchDisableAction extends BDBatchDisableAction {

	
	public MaschineBatchDisableAction(){
		this.setStatusField("mstatus");
		this.setStatusValue("2");
	}
	
	
	@Override
	public ValueObjWithErrLog doDisable(SuperVO[] vos) throws Exception {
		// TODO 自动生成的方法存根
		MaschineVO[] vmaschineVOs=new MaschineVO[vos.length];
		
		for (int i = 0; i < vos.length; i++) {
			
			if(vos[i] instanceof MaschineVO){
				vmaschineVOs[i]=(MaschineVO) vos[i];
			}
			
		}
		
		return this.getService().disableMaschineVO(vmaschineVOs);
	}	
	
	protected String checkData(Object obj) {
		String msg = null;
		if (isDisabled((SuperVO)obj)) {
			msg = NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0078");
		}else if(isUnEable((SuperVO)obj)){
			msg = "数据未启用，不能停用";
		}else if (isNotManageable(obj)) {
			msg = ManageModeUtil.getDisManageableMsg(getModel().getContext().getNodeType());
		} else if (isNotHasDataHasPermission(obj)) {
			msg = IShowMsgConstant.getDataPermissionInfo();
		} else {
			msg = getValidationMsg(obj);
		}
		return msg;
	}
	
	private boolean isUnEable(SuperVO vo) {
		// TODO 自动生成的方法存根
		if (vo != null) {
			String status=(String) vo.getAttributeValue(this.getStatusField());
			if((status !=null) && "0".equals(status)){
				return true;
			}
		}
		return false;
	}
	
	private String getValidationMsg(Object obj)
	{
		try {
			validate(obj);
		} catch (BusinessExceptionAdapter e) {
			return e.getMessage();
		}
		return null;
	}
	
	public MaschineMaintainService getService() {
		
		MaschineMaintainService service=(MaschineMaintainService)((BillManageModel)getModel()).getService();
		return service;
	}
	
	

}
