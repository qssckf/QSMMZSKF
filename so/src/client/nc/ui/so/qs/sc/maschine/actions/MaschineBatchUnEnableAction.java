package nc.ui.so.qs.sc.maschine.actions;

import java.util.Collection;

import nc.bs.bd.service.ValueObjWithErrLog;
import nc.bs.uif2.BusinessExceptionAdapter;
import nc.md.model.MetaDataException;
import nc.md.persist.framework.IMDPersistenceQueryService;
import nc.md.persist.framework.MDPersistenceService;
//import nc.ui.so.xlx.tran.driver.service.DriverAppModelService;
import nc.ui.uif2.CheckDataPermissionUtil;
import nc.ui.uif2.IShowMsgConstant;
import nc.ui.uif2.UIState;
import nc.ui.uif2.model.BillManageModel;
//import nc.ui.xlx.action.batch.BDBatchUnEnableAction;
//import nc.ui.xlx.action.bill.BDUnEnableAction;
import nc.ui.so.qs.sc.action.bill.BDUnEnableAction;
import nc.ui.so.qs.sc.action.batch.BDBatchUnEnableAction;
import nc.ui.so.qs.sc.maschine.service.MaschineMaintainService;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
//import nc.vo.so.xlx.tran.CarVO;
//import nc.vo.so.xlx.tran.DriverVO;
import nc.vo.so.qs.sc.MaschineVO;
import nc.vo.util.ManageModeUtil;

public class MaschineBatchUnEnableAction extends BDBatchUnEnableAction {

	public MaschineBatchUnEnableAction(){
		this.setStatusField("mstatus");
		this.setStatusValue("0");
	}
	
	@Override
	public ValueObjWithErrLog doUnEnable(SuperVO[] vos)
			throws Exception {
		// TODO 自动生成的方法存根
		
		MaschineVO[] vmaschineVOs=new MaschineVO[vos.length];
		
		for (int i = 0; i < vos.length; i++) {
			
			if(vos[i] instanceof MaschineVO){
				vmaschineVOs[i]=(MaschineVO) vos[i];
			}
			
		}
		
		return this.getService().unenableMaschineVO(vmaschineVOs);
	}
	
	public MaschineMaintainService getService() {
		
		MaschineMaintainService service=(MaschineMaintainService)((BillManageModel)getModel()).getService();
		return service;
	}

	@Override
	protected String checkData(Object obj) throws Exception {
		// TODO 自动生成的方法存根
		String msg = null;
		
		if (isUnEnabled((SuperVO)obj)) {
			msg="数据未启用无法取消启用";
		}else if(isDisable((SuperVO)obj)){
			msg="数据已停用无法取消启用";
//		}else if(isCarCheck((SuperVO)obj)){
//			msg="数据被车辆档案引用，不能取消启用！";
		}else if(isNotManageable(obj)) {
			msg = ManageModeUtil.getDisManageableMsg(getModel().getContext().getNodeType());
		}else if(isNotHasDataHasPermission(obj)){
			msg = IShowMsgConstant.getDataPermissionInfo();
		}else{
			msg = getValidationMsg(obj);
		}
		
		return msg;
	}
	
//	private boolean isCarCheck(SuperVO obj) throws BusinessException {
//		// TODO 自动生成的方法存根
//		
//		
//		
//		try {
//			
//			String pk_user=(String) obj.getAttributeValue("pk_driver");
//			
//			Collection<CarVO> cars=this.getMDQueryService().queryBillOfVOByCond(CarVO.class,"(pk_driver='"+pk_user+"' or pk_driver1='"+pk_user+"' or pk_driver2='"+pk_user+"' or pk_escort='"+pk_user+"' or pk_escort1='"+pk_user+"' or pk_escort2='"+pk_user+"') and dr=0",false);
//		
//			if(cars.size()>0){
//				return true;
//			}
//		
//		} catch (MetaDataException e) {
//			// TODO 自动生成的 catch 块
//			throw new BusinessException(e);
//		}
//		
//		return false;
//	}

	private String getValidationMsg(Object vo) {
		// TODO 自动生成的方法存根
		
		try {
			validate(vo);
		}catch(BusinessExceptionAdapter e){
			return e.getMessage();
		}
		
		return null;
	}
	
	private boolean isNotHasDataHasPermission(Object obj) {
		// TODO 自动生成的方法存根
		String userId = getModel().getContext().getPk_loginUser();
		String pkgroup = getModel().getContext().getPk_group();
		return !CheckDataPermissionUtil.checkDataPermission(this.getOperateCode(), this.getMdOperateCode(), this.getResourceCode(), userId, pkgroup, obj);
	}
	
	private boolean isNotManageable(Object obj) {
		// TODO 自动生成的方法存根
		return !ManageModeUtil.manageable(obj, getModel().getContext());
	}

	private boolean isDisable(SuperVO vo) {
		// TODO 自动生成的方法存根
		if (vo != null) {
			String status=(String) vo.getAttributeValue(this.getStatusField());
			if((status !=null) && "2".equals(status)){
				return true;
			}
		}
		return false;
	}
	
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

	private boolean isUnEnabled(SuperVO vo) {
		// TODO 自动生成的方法存根
		if (vo != null) {
			String status=(String) vo.getAttributeValue(this.getStatusField());
			if((status !=null) && "0".equals(status)){
				return true;
			}
		}
		return false;
	}
	
	private IMDPersistenceQueryService getMDQueryService() {
		
		return MDPersistenceService.lookupPersistenceQueryService();
	}

}
