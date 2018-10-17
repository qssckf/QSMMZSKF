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
		// TODO �Զ����ɵķ������
		
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
		// TODO �Զ����ɵķ������
		String msg = null;
		
		if (isUnEnabled((SuperVO)obj)) {
			msg="����δ�����޷�ȡ������";
		}else if(isDisable((SuperVO)obj)){
			msg="������ͣ���޷�ȡ������";
//		}else if(isCarCheck((SuperVO)obj)){
//			msg="���ݱ������������ã�����ȡ�����ã�";
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
//		// TODO �Զ����ɵķ������
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
//			// TODO �Զ����ɵ� catch ��
//			throw new BusinessException(e);
//		}
//		
//		return false;
//	}

	private String getValidationMsg(Object vo) {
		// TODO �Զ����ɵķ������
		
		try {
			validate(vo);
		}catch(BusinessExceptionAdapter e){
			return e.getMessage();
		}
		
		return null;
	}
	
	private boolean isNotHasDataHasPermission(Object obj) {
		// TODO �Զ����ɵķ������
		String userId = getModel().getContext().getPk_loginUser();
		String pkgroup = getModel().getContext().getPk_group();
		return !CheckDataPermissionUtil.checkDataPermission(this.getOperateCode(), this.getMdOperateCode(), this.getResourceCode(), userId, pkgroup, obj);
	}
	
	private boolean isNotManageable(Object obj) {
		// TODO �Զ����ɵķ������
		return !ManageModeUtil.manageable(obj, getModel().getContext());
	}

	private boolean isDisable(SuperVO vo) {
		// TODO �Զ����ɵķ������
		if (vo != null) {
			String status=(String) vo.getAttributeValue(this.getStatusField());
			if((status !=null) && "2".equals(status)){
				return true;
			}
		}
		return false;
	}
	
	protected boolean isEnabled(SuperVO vo) {
		// TODO �Զ����ɵķ������
		if (vo != null) {
			String status=(String) vo.getAttributeValue(this.getStatusField());
			if((status !=null) && "1".equals(status)){
				return true;
			}
		}
		return false;
	}

	private boolean isUnEnabled(SuperVO vo) {
		// TODO �Զ����ɵķ������
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
