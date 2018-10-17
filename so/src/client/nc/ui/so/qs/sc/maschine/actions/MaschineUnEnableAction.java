package nc.ui.so.qs.sc.maschine.actions;

import java.util.ArrayList;
import java.util.List;

import nc.bs.bd.service.ValueObjWithErrLog;
import nc.bs.uif2.validation.IValidationService;
import nc.ui.pubapp.uif2app.validation.CompositeValidation;
//import nc.ui.so.xlx.tran.driver.service.DriverAppModelService;
//import nc.ui.so.xlx.tran.driver.validation.DriverInfoUseValidation;
//import nc.ui.xlx.action.bill.BDUnEnableAction;
import nc.ui.so.qs.sc.action.bill.BDUnEnableAction;
import nc.ui.so.qs.sc.maschine.service.MaschineMaintainService;
import nc.vo.pub.SuperVO;
import nc.ui.uif2.model.BillManageModel;

public class MaschineUnEnableAction extends BDUnEnableAction {
	

	
	public MaschineUnEnableAction(){
		this.setStatusField("mstatus");
		this.setStatusValue("0");
		
		
		List<IValidationService> vlist=new ArrayList();
		//确认车辆档案是否引用
//		vlist.add(new MaschineInfoUseValidation());
		
		CompositeValidation validation=new nc.ui.pubapp.uif2app.validation.CompositeValidation();
		
		validation.setValidators(vlist);
		
		this.setValidationService(validation);

	}

	@Override
	public Object doUnEnable(Object obj) throws Exception {
		// TODO 自动生成的方法存根
		ValueObjWithErrLog reVoErrLog = getService().unenableMaschineVO(obj);
		return reVoErrLog.getVos()[0];

	}
	
	public MaschineMaintainService getService() {
		
		MaschineMaintainService service=(MaschineMaintainService)((BillManageModel)getModel()).getService();
		return service;
	}
	

}
