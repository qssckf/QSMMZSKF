package nc.ui.so.qs.sc.maschine.actions;

import nc.bs.bd.service.ValueObjWithErrLog;
import nc.ui.bd.pub.actions.BDDisableAction;
import nc.ui.uif2.model.BillManageModel;
import nc.ui.so.qs.sc.maschine.service.MaschineMaintainService;
//import nc.ui.so.xlx.tran.driver.service.DriverAppModelService;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pub.CircularlyAccessibleValueObject;

public class MaschineDisableAction extends BDDisableAction {

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

	public MaschineDisableAction(){
		this.setStatusField("mstatus");
		this.setStatusValue("2");
	}
	
	
	@Override
	public Object doDisable(Object obj) throws Exception {
		// TODO 自动生成的方法存根
		
		ValueObjWithErrLog reVoErrLog = getService().disableMaschineVO(obj);
		return reVoErrLog.getVos()[0];
	}
	
	public MaschineMaintainService getService() {
		
		MaschineMaintainService service=(MaschineMaintainService)((BillManageModel)getModel()).getService();
		return service;
	}

	@Override
	public boolean isCurrentDataEnable() {
		// TODO 自动生成的方法存根
		CircularlyAccessibleValueObject vo = (CircularlyAccessibleValueObject)getModel().getSelectedData();
		
		if(StringUtil.isEmpty(this.getStatusField())){
			this.setStatusField("enablestate");
		}
		
		return (vo.getAttributeValue(this.getStatusField()) != null) && ("1".equals(vo.getAttributeValue(this.getStatusField())));
	}
	
	

}
