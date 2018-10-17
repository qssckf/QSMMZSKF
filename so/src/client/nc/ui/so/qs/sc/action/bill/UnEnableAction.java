package nc.ui.so.qs.sc.action.bill;

import java.awt.event.ActionEvent;

import nc.bs.uif2.BusinessExceptionAdapter;
import nc.bs.uif2.validation.IValidationService;
import nc.bs.uif2.validation.ValidationException;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.uif2.CheckDataPermissionUtil;
import nc.ui.uif2.IShowMsgConstant;
import nc.ui.uif2.NCAction;
import nc.ui.uif2.UIState;
import nc.ui.uif2.editor.IEditor;
import nc.ui.uif2.model.AbstractAppModel;
//import nc.ui.xlx.actions.ActionInitializer;
import nc.ui.so.qs.sc.actions.ActionInitializer;
import nc.vo.jcom.lang.StringUtil;
import nc.vo.pub.BusinessException;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.SuperVO;

public abstract class UnEnableAction extends NCAction {
	
	private AbstractAppModel model;
	private IEditor editor;
	private IValidationService validationService;
	private String mdOperateCode = null;
	private String operateCode = null;
	private String resourceCode = null;
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

	public AbstractAppModel getModel() {
		return model;
	}

	public void setModel(AbstractAppModel model) {
		this.model = model;
		model.addAppEventListener(this);
	}

	public IEditor getEditor() {
		return editor;
	}

	public void setEditor(IEditor editor) {
		this.editor = editor;
	}

	public IValidationService getValidationService() {
		return validationService;
	}

	public void setValidationService(IValidationService validationService) {
		this.validationService = validationService;
	}

	public String getMdOperateCode() {
		return mdOperateCode;
	}

	public void setMdOperateCode(String mdOperateCode) {
		this.mdOperateCode = mdOperateCode;
	}

	public String getOperateCode() {
		return operateCode;
	}

	public void setOperateCode(String operateCode) {
		this.operateCode = operateCode;
	}

	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}


	
	public UnEnableAction(){
		ActionInitializer.initializeAction(this, "UnEnable");
	}

	@Override
	public void doAction(ActionEvent event) throws Exception {
		// TODO 自动生成的方法存根
		checkPermission();
		
		validate();
		
		doUnEnable();
		
	}
	
	

	@Override
	protected boolean isActionEnable() {
		// TODO 自动生成的方法存根
		return (getModel().getUiState() == UIState.NOT_EDIT) && (this.model.getSelectedData() != null) && (isCurrentDataEnable());
	}

	private boolean isCurrentDataEnable() {
		// TODO 自动生成的方法存根
		
		
		CircularlyAccessibleValueObject vo = (CircularlyAccessibleValueObject)getModel().getSelectedData();
		
		if(StringUtil.isEmpty(this.getStatusField())){
			this.setStatusField("enablestate");
		}
		
		return (vo.getAttributeValue(this.getStatusField()) != null) && ("1".equals(vo.getAttributeValue(this.getStatusField())));
	}

	private void doUnEnable() throws Exception {
		// TODO 自动生成的方法存根
		SuperVO vo = (SuperVO)getModel().getSelectedData();
		
		if (4==MessageDialog.showYesNoDlg(this.getModel().getContext().getEntranceUI(), "提醒", "是否将当前状态取消启用？", 8)){
			
			Object newobj = doUnEnable(vo);
			
			if ((newobj instanceof Object[])) {
				this.model.directlyUpdate((Object[])newobj);
			}else{
				this.model.directlyUpdate(newobj);
			}
		}
		
	}

	public abstract Object doUnEnable(Object vo) throws Exception;;

	private void validate() {
		// TODO 自动生成的方法存根
		SuperVO vo = (SuperVO)getModel().getSelectedData();
		
		validate(vo);
	}

	protected void validate(Object vo) {
		// TODO 自动生成的方法存根
		if (this.validationService != null) {
			try {
				this.validationService.validate(vo);
			} catch (ValidationException e) {
				// TODO 自动生成的 catch 块
				throw new BusinessExceptionAdapter(e);
			}
		}
	}

	private void checkPermission() throws Exception {
		// TODO 自动生成的方法存根
		Object[] objs = getUnDataPermissionData();
		 if ((objs != null) && (objs.length > 0)){
			 throw new BusinessException(IShowMsgConstant.getDataPermissionInfo());
		 }
	}
	
	protected Object[] getUnDataPermissionData(){
		Object obj = getCheckData();
		return CheckDataPermissionUtil.getUnDataPermissionData(this.operateCode, this.mdOperateCode, this.resourceCode, this.model.getContext(), obj);
	}

	protected Object getCheckData(){
		return this.getModel().getSelectedData();
	}

}
