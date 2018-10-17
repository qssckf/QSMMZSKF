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
/*     */ import nc.ui.uif2.actions.EnableAction;
/*     */ import nc.ui.uif2.model.AbstractAppModel;
/*     */ import nc.ui.uif2.model.BillManageModel;
/*     */ import nc.ui.uif2.model.HierachicalDataAppModel;
import nc.vo.ecpubapp.tools.IEbpurConstant;
/*     */ import nc.vo.ml.AbstractNCLangRes;
/*     */ import nc.vo.ml.NCLangRes4VoTransl;
import nc.vo.pm.util.ArrayUtil;
/*     */ import nc.vo.pub.BusinessException;
/*     */ import nc.vo.pub.SuperVO;
/*     */ import nc.vo.uif2.LoginContext;
/*     */ import nc.vo.util.ManageModeUtil;

/*     */ import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ public abstract class BDBatchEnableAction
/*     */   extends EnableAction
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
/*     */   
/*     */   public BDBatchEnableAction() {}
			
			private String StatusField=null;
			
			public String getStatusField() {
				return StatusField;
			}
			public void setStatusField(String statusField) {
				StatusField = statusField;
			}

			private String StatusValue=null;
			
			
			public String getStatusValue() {
				return StatusValue;
			}
			public void setStatusValue(String statusValue) {
				StatusValue = statusValue;
			}
/*     */   
/*     */   public abstract ValueObjWithErrLog doEnable(SuperVO[] paramArrayOfSuperVO) throws Exception;
/*     */   
/*     */   public final Object doEnable(Object obj) throws Exception {
/*  47 */     return null;
/*     */   }
/*     */   
/*     */   public void doAction(ActionEvent e) throws Exception
/*     */   {
/*  52 */     checkSelectDataNull();
/*  53 */     if (2 == showConfirmDialog()) {
/*  54 */       return;
/*     */     }
/*  56 */     ValueObjWithErrLog value = filerCanDisableData(getSelectedOperaDatas());
/*  57 */     if ((value.getVos() != null) && (value.getVos().length > 0)) {
/*  58 */       ValueObjWithErrLog disabledRst = doEnable(value.getVos());
/*  59 */       if (disabledRst != null) {
				  if(ArrayUtil.isNotEmpty(value.getVos()) && (value.getVos().length==1)){
					  getModel().directlyUpdate(disabledRst.getVos()[0]);
				  }else{
					  getModel().directlyUpdate(disabledRst.getVos());
				  }
/*  60 */         
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
///*  73 */     ShowStatusBarMsgUtil.showStatusBarMsg(IEbpurConstant.getEnableSuccessMsg(), getModel().getContext());
///*     */   }
/*     */   
/*     */   private void checkSelectDataNull()
/*     */     throws BusinessException
/*     */   {
/*  79 */     Object[] selectedObjs = getSelectedOperaDatas();
/*  80 */     if ((selectedObjs == null) || (selectedObjs.length == 0)) {
/*  81 */       throw new BusinessException(NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0042"));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private int showConfirmDialog()
/*     */   {
/*  88 */     return MessageDialog.showOkCancelDlg(getModel().getContext().getEntranceUI(), null, NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0043"));
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
/*     */   public abstract String checkData(Object obj) throws Exception;
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
/*     */   protected String getValidationMsg(Object obj)
/*     */   {
/*     */     try {
/* 137 */       validate(obj);
/*     */     } catch (BusinessExceptionAdapter e) {
/* 139 */       return e.getMessage();
/*     */     }
/* 141 */     return null;
/*     */   }
/*     */   
/*     */   protected void showErrorLog(ArrayList<ErrLogElement> errLogList) {
/* 145 */     if ((errLogList != null) && (errLogList.size() > 0)) {
/* 146 */       StringBuilder errMsg = new StringBuilder(NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0044", null, new String[] { this.operateObj }) + "\n");
/*     */       
/*     */ 
/*     */ 
/* 150 */       for (int i = 0; i < errLogList.size(); i++) {
/* 151 */         ErrLogElement element = (ErrLogElement)errLogList.get(i);
/* 152 */         errMsg.append(NCLangRes4VoTransl.getNCLangRes().getStrByID("bdpub", "0bdpub0037", null, new String[] { element.getErrCode(), element.getErrName(), element.getErrReason() }) + "\n");
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 157 */       ShowStatusBarMsgUtil.showErrorMsg(NCLangRes.getInstance().getStrByID("uif2", "ExceptionHandlerUtil-000001"), errMsg.toString(), getModel().getContext());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean isActionEnable()
/*     */   {
/* 165 */     boolean enable = (getModel().getUiState() == UIState.NOT_EDIT) || (getModel().getUiState() == UIState.INIT);
/*     */     
/* 167 */     Object[] selectedObjs = getSelectedOperaDatas();
/* 168 */     if ((selectedObjs == null) || (selectedObjs.length == 0)) {
/* 169 */       enable = false;
/* 170 */     } else if ((selectedObjs.length == 1) && 
/* 171 */       (isEnabled((SuperVO)selectedObjs[0]))) {
/* 172 */       enable = false;
/*     */     }
/* 174 */     return enable;
/*     */   }
/*     */   
/*     */   protected boolean isEnabled(SuperVO vo) {
/* 178 */     if (vo != null) {
/* 179 */       Integer enablestate = (Integer)vo.getAttributeValue("enablestate");
/* 180 */       if ((enablestate != null) && (enablestate.equals(Integer.valueOf(2))))
/* 181 */         return true;
/*     */     }
/* 183 */     return false;
/*     */   }
/*     */   
/*     */   protected Object[] getSelectedOperaDatas() {
/* 187 */     if ((getModel() instanceof BillManageModel))
/* 188 */       return ((BillManageModel)getModel()).getSelectedOperaDatas();
/* 189 */     if ((getModel() instanceof HierachicalDataAppModel)) {
/* 190 */       return ((HierachicalDataAppModel)getModel()).getSelectedDatas();
/*     */     }
/* 192 */     return new Object[] { getModel().getSelectedData() };
/*     */   }
/*     */   
/*     */ 
/*     */   public void setMdOperateCode(String mdOperateCode)
/*     */   {
/* 198 */     this.mdOperateCode = mdOperateCode;
/*     */   }
/*     */   
/*     */   public void setOperateCode(String operateCode)
/*     */   {
/* 203 */     this.operateCode = operateCode;
/*     */   }
/*     */   
/*     */   public void setResourceCode(String resourceCode)
/*     */   {
/* 208 */     this.resourceCode = resourceCode;
/*     */   }
/*     */ }
