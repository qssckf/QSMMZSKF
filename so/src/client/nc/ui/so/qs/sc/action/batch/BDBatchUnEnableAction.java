package nc.ui.so.qs.sc.action.batch;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import nc.bs.bd.service.ErrLogElement;
import nc.bs.bd.service.ValueObjWithErrLog;
//import nc.bs.bd.util.IEnableMsgConstant;
import nc.bs.uif2.BusinessExceptionAdapter;
import nc.ui.ml.NCLangRes;
import nc.ui.pub.beans.MessageDialog;
import nc.ui.uif2.CheckDataPermissionUtil;
import nc.ui.uif2.IShowMsgConstant;
import nc.ui.uif2.ShowStatusBarMsgUtil;
import nc.ui.uif2.UIState;
import nc.ui.uif2.model.BillManageModel;
import nc.ui.uif2.model.HierachicalDataAppModel;
//import nc.ui.xlx.action.bill.UnEnableAction;
import nc.ui.so.qs.sc.action.bill.UnEnableAction;
import nc.vo.ml.NCLangRes4VoTransl;
import nc.vo.pub.BusinessException;
import nc.vo.pub.SuperVO;
import nc.vo.util.ManageModeUtil;

public abstract class BDBatchUnEnableAction extends UnEnableAction{
	
	public BDBatchUnEnableAction(){}

	private String operateObj = NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0030");
	
	public abstract ValueObjWithErrLog doUnEnable(SuperVO[] paramArrayOfSuperVO) throws Exception;
	
	@Override
	public void doAction(ActionEvent event) throws Exception {
		// TODO 自动生成的方法存根
		
		checkSelectDataNull();
		
		if (2 == showConfirmDialog()) {
			return;
		}
		
		ValueObjWithErrLog value = filerCanUnEnableData(getSelectedOperaDatas());
		if ((value.getVos() != null) && (value.getVos().length > 0)) {
			ValueObjWithErrLog undisabledRst = doUnEnable(value.getVos());
			if(undisabledRst!=null){
				getModel().directlyUpdate(undisabledRst.getVos());
				value.getErrLogList().addAll(undisabledRst.getErrLogList());
			}
		}
		if (!CollectionUtils.isEmpty(value.getErrLogList())) {
			showErrorLog(value.getErrLogList());
		}else{
			showSuccessInfo();
		}
		
	}

	private void showSuccessInfo() {
		// TODO 自动生成的方法存根
		ShowStatusBarMsgUtil.showStatusBarMsg("取消启用成功！", getModel().getContext());
	}

	@Override
	protected boolean isActionEnable() {
		// TODO 自动生成的方法存根
		boolean enable = (getModel().getUiState() == UIState.NOT_EDIT) || (getModel().getUiState() == UIState.INIT);
		
		Object[] selectedObjs = getSelectedOperaDatas();
		
		if ((selectedObjs == null) || (selectedObjs.length == 0)) {
			enable = false;
		}else if ((selectedObjs.length == 1) && (isUnEnabled((SuperVO)selectedObjs[0]) || isDisable((SuperVO)selectedObjs[0]))){
			enable = false;
		}
		return enable;
	}

	@Override
	public Object doUnEnable(Object vo) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	private void showErrorLog(ArrayList<ErrLogElement> errLogList) {
		// TODO 自动生成的方法存根
		if ((errLogList != null) && (errLogList.size() > 0)) {
			StringBuilder errMsg = new StringBuilder(NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0044", null, new String[] { this.operateObj }) + "\n");
		
			for (int i = 0; i < errLogList.size(); i++) {
				ErrLogElement element = (ErrLogElement)errLogList.get(i);
				errMsg.append(NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0037", null, new String[] { element.getErrCode(), element.getErrName(), element.getErrReason() }) + "\n");
			}
			
			ShowStatusBarMsgUtil.showErrorMsg(NCLangRes.getInstance().getStrByID("uif2", "ExceptionHandlerUtil-000001"), errMsg.toString(), getModel().getContext());
		
		}
	}


	private ValueObjWithErrLog filerCanUnEnableData(Object[] vos) throws Exception {
		// TODO 自动生成的方法存根
		List<SuperVO> canUnEnableVOs = new ArrayList();
		
		ArrayList<ErrLogElement> errList = new ArrayList();
		
		for (Object obj : vos) {
			String msg = checkData(obj);
			if(StringUtils.isNotEmpty(msg)){
				errList.add(new ErrLogElement((SuperVO)obj, msg));
			}else{
				canUnEnableVOs.add((SuperVO) obj);
			}
		}
		
		return new ValueObjWithErrLog((SuperVO[])canUnEnableVOs.toArray(new SuperVO[0]), errList);
	}

	protected abstract String checkData(Object obj) throws Exception;

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

	private int showConfirmDialog() {
		// TODO 自动生成的方法存根
		return MessageDialog.showOkCancelDlg(getModel().getContext().getEntranceUI(), null, "是否将选择数据取消启用？");
	}

	private void checkSelectDataNull() throws BusinessException{
		// TODO 自动生成的方法存根
		Object[] selectedObjs = getSelectedOperaDatas();
		if ((selectedObjs == null) || (selectedObjs.length == 0)) {
			throw new BusinessException(NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0042"));
		}
	}

	protected Object[] getSelectedOperaDatas() {
		// TODO 自动生成的方法存根
		
		 if ((getModel() instanceof BillManageModel)){
			 return ((BillManageModel)getModel()).getSelectedOperaDatas();
		 }
		 if ((getModel() instanceof HierachicalDataAppModel)){
			 return ((HierachicalDataAppModel)getModel()).getSelectedDatas();
		 }
		
		 return new Object[] { getModel().getSelectedData() };
	};
	
	
	

}
