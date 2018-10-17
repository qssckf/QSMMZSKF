package nc.ui.so.qs.sc.action.batch;
/*     */ 
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;

/*     */ import nc.bs.bd.service.ErrLogElement;
/*     */ import nc.bs.bd.service.ValueObjWithErrLog;
///*     */ import nc.bs.bd.util.IEnableMsgConstant;
/*     */ import nc.bs.uif2.BusinessExceptionAdapter;
/*     */ import nc.ui.ml.NCLangRes;
/*     */ import nc.ui.pub.beans.MessageDialog;
/*     */ import nc.ui.uif2.CheckDataPermissionUtil;
/*     */ import nc.ui.uif2.IShowMsgConstant;
/*     */ import nc.ui.uif2.ShowStatusBarMsgUtil;
/*     */ import nc.ui.uif2.UIState;
/*     */ import nc.ui.uif2.actions.DisableAction;
/*     */ import nc.ui.uif2.model.AbstractAppModel;
/*     */ import nc.ui.uif2.model.BillManageModel;
/*     */ import nc.ui.uif2.model.HierachicalDataAppModel;
/*     */ import nc.vo.ml.AbstractNCLangRes;
/*     */ import nc.vo.ml.NCLangRes4VoTransl;
/*     */ import nc.vo.pub.BusinessException;
/*     */ import nc.vo.pub.SuperVO;
/*     */ import nc.vo.uif2.LoginContext;
/*     */ import nc.vo.util.ManageModeUtil;

/*     */ import org.apache.commons.collections.CollectionUtils;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ public abstract class BDBatchDisableAction
/*     */   extends DisableAction
/*     */ {
/*  32 */   private String mdOperateCode = null;
/*     */   
/*  34 */   private String operateCode = null;
/*     */   
/*  36 */   private String resourceCode = null;
/*     */   
/*     */   public static final String ENABLESTATE = "enablestate";
/*     */   
/*  40 */   private String operateObj = NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0030");

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
/*     */   
/*     */   public BDBatchDisableAction() {}
/*     */   
/*     */   public final Object doDisable(Object obj) throws Exception {
/*  45 */     return null;
/*     */   }
/*     */   
/*     */   public abstract ValueObjWithErrLog doDisable(SuperVO[] paramArrayOfSuperVO) throws Exception;
/*     */   
/*     */   public void doAction(ActionEvent e) throws Exception
/*     */   {
/*  52 */     checkSelectDataNull();
/*  53 */     if (2 == showConfirmDialog()) {
/*  54 */       return;
/*     */     }
/*  56 */     ValueObjWithErrLog value = filerCanDisableData(getSelectedOperaDatas());
/*  57 */     if ((value.getVos() != null) && (value.getVos().length > 0)) {
/*  58 */       ValueObjWithErrLog disabledRst = doDisable(value.getVos());
/*  59 */       if (disabledRst != null) {
/*  60 */         getModel().directlyUpdate(disabledRst.getVos());
/*  61 */         value.getErrLogList().addAll(disabledRst.getErrLogList());
/*     */       }
/*     */     }
/*  64 */     if (!CollectionUtils.isEmpty(value.getErrLogList())) {
/*  65 */       showErrorLog(value.getErrLogList());
/*     */     } else {
///*  67 */       showSuccessInfo();
/*     */     }
/*     */   }
/*     */   
///*     */   protected void showSuccessInfo()
///*     */   {
///*  73 */     ShowStatusBarMsgUtil.showStatusBarMsg(IEnableMsgConstant.getDisableSuccessMsg(), getModel().getContext());
///*     */   }
/*     */   
/*     */   private void checkSelectDataNull()
/*     */     throws BusinessException
/*     */   {
/*  79 */     Object[] selectedObjs = getSelectedOperaDatas();
/*  80 */     if ((selectedObjs == null) || (selectedObjs.length == 0)) {
/*  81 */       throw new BusinessException(NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0040"));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected int showConfirmDialog()
/*     */   {
/*  88 */     return MessageDialog.showOkCancelDlg(getModel().getContext().getEntranceUI(), null, NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0041"));
/*     */   }
/*     */   
/*     */ 
/*     */   private ValueObjWithErrLog filerCanDisableData(Object[] vos) throws Exception
/*     */   {
/*  94 */     List<SuperVO> canDisableVOs = new ArrayList();
/*  95 */     ArrayList<ErrLogElement> errList = new ArrayList();
/*  96 */     for (Object obj : vos) {
/*  97 */       String msg = checkData(obj);
/*  98 */       if (StringUtils.isNotBlank(msg)) {
/*  99 */         errList.add(new ErrLogElement((SuperVO)obj, msg));
/*     */       } else {
/* 101 */         canDisableVOs.add((SuperVO)obj);
/*     */       }
/*     */     }
/* 104 */     return new ValueObjWithErrLog((SuperVO[])canDisableVOs.toArray(new SuperVO[0]), errList);
/*     */   }
/*     */   
/*     */   protected abstract String checkData(Object obj) throws Exception;

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
/*     */   
/*     */   protected boolean isNotManageable(Object obj) {
/* 125 */     return !ManageModeUtil.manageable(obj, getModel().getContext());
/*     */   }
/*     */   
/*     */   protected boolean isNotHasDataHasPermission(Object obj) {
/* 129 */     String userId = getModel().getContext().getPk_loginUser();
/* 130 */     String pkgroup = getModel().getContext().getPk_group();
/* 131 */     return !CheckDataPermissionUtil.checkDataPermission(this.operateCode, this.mdOperateCode, this.resourceCode, userId, pkgroup, obj);
/*     */   }
/*     */   
/*     */   private String getValidationMsg(Object obj)
/*     */   {
/*     */     try {
/* 137 */       validate(obj);
/*     */     } catch (BusinessExceptionAdapter e) {
/* 139 */       return e.getMessage();
/*     */     }
/* 141 */     return null;
/*     */   }
/*     */   
/*     */   protected boolean isActionEnable()
/*     */   {
/* 146 */     boolean enable = (getModel().getUiState() == UIState.NOT_EDIT) || (getModel().getUiState() == UIState.INIT);
/*     */     
/* 148 */     Object[] selectedObjs = getSelectedOperaDatas();
/* 149 */     if ((selectedObjs == null) || (selectedObjs.length == 0)) {
/* 150 */       enable = false;
/* 151 */     } else if ((selectedObjs.length == 1) && (isDisabled((SuperVO)selectedObjs[0]) || isUnEable((SuperVO)selectedObjs[0]))) {
/* 153 */       enable = false;
/*     */     }
/* 155 */     return enable;
/*     */   }
/*     */   
/*     */   protected boolean isDisabled(SuperVO vo) {
				if (vo != null) {
					String status=(String) vo.getAttributeValue(this.getStatusField());
					if((status !=null) && "2".equals(status)){
						return true;
					}
				}
				return false;
/*     */   }
/*     */   
/*     */   protected Object[] getSelectedOperaDatas() {
/* 168 */     if ((getModel() instanceof BillManageModel))
/* 169 */       return ((BillManageModel)getModel()).getSelectedOperaDatas();
/* 170 */     if ((getModel() instanceof HierachicalDataAppModel)) {
/* 171 */       return ((HierachicalDataAppModel)getModel()).getSelectedDatas();
/*     */     }
/* 173 */     return new Object[] { getModel().getSelectedData() };
/*     */   }
/*     */   
/*     */   protected void showErrorLog(ArrayList<ErrLogElement> errLogList)
/*     */   {
/* 178 */     if ((errLogList != null) && (errLogList.size() > 0)) {
/* 179 */       StringBuilder errMsg = new StringBuilder(NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0039", null, new String[] { this.operateObj }) + "\n");
/*     */       
/*     */ 
/*     */ 
/* 183 */       for (int i = 0; i < errLogList.size(); i++) {
/* 184 */         ErrLogElement element = (ErrLogElement)errLogList.get(i);
/* 185 */         errMsg.append(NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0037", null, new String[] { element.getErrCode(), element.getErrName(), element.getErrReason() }) + "\n");
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 190 */       ShowStatusBarMsgUtil.showErrorMsg(NCLangRes.getInstance().getStrByID("uif2", "ExceptionHandlerUtil-000002"), errMsg.toString(), getModel().getContext());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void setMdOperateCode(String mdOperateCode)
/*     */   {
/* 197 */     this.mdOperateCode = mdOperateCode;
/*     */   }
/*     */   
/*     */   public void setOperateCode(String operateCode) {
/* 201 */     this.operateCode = operateCode;
/*     */   }
/*     */   
/*     */   public void setResourceCode(String resourceCode) {
/* 205 */     this.resourceCode = resourceCode;
/*     */   }
/*     */ }
