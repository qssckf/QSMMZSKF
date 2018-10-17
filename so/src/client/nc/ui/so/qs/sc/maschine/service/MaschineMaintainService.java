package nc.ui.so.qs.sc.maschine.service;
/*    */ 
/*    */ import nc.bs.bd.service.ValueObjWithErrLog;
///*    */ import nc.itf.pd.pd0404.IPDWkMaintain;
/*    */ import nc.ui.pubapp.uif2app.actions.IDataOperationService;
///*    */ import nc.vo.pd.pd0404.entity.AggWkVO;
/*    */ import nc.vo.pub.BusinessException;
/*    */ import nc.vo.pubapp.pattern.model.entity.bill.IBill;
		import nc.itf.so.qs.sc.maschine.service.IMaschineMaintain;
		import nc.vo.so.qs.sc.AggMaschineVO;
		import nc.bs.framework.common.NCLocator;
		import nc.vo.so.qs.sc.MaschineVO;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MaschineMaintainService
/*    */   implements IDataOperationService
/*    */ {
/*    */   public MaschineMaintainService() {}
/*    */   
/*    */   public IBill[] insert(IBill[] value) throws BusinessException {
/* 22 */     IMaschineMaintain operator = (IMaschineMaintain)NCLocator.getInstance().lookup(IMaschineMaintain.class);
/* 23 */     AggMaschineVO[] vos = operator.insert((AggMaschineVO[])value);
/* 24 */     return vos;
/*    */   }
/*    */   
/*    */   public IBill[] update(IBill[] value) throws BusinessException {
/* 29 */     IMaschineMaintain operator = (IMaschineMaintain)NCLocator.getInstance().lookup(IMaschineMaintain.class);
/* 30 */     AggMaschineVO[] vos = operator.update((AggMaschineVO[])value);
/* 31 */     return vos;
/*    */   }
/*    */   
/*    */   public IBill[] delete(IBill[] value) throws BusinessException {
/* 36 */     IMaschineMaintain operator = (IMaschineMaintain)NCLocator.getInstance().lookup(IMaschineMaintain.class);
/* 37 */     operator.delete((AggMaschineVO[])value);
/* 38 */     return value;
/*    */   }
		   public ValueObjWithErrLog enableMaschineVO(Object object) throws BusinessException {
			   IMaschineMaintain operator = (IMaschineMaintain)NCLocator.getInstance().lookup(IMaschineMaintain.class);
			   if(object instanceof MaschineVO[]){
				   return operator.enableMaschine((MaschineVO[])object);
			   }else if(object instanceof MaschineVO){
				   return operator.enableMaschine(new MaschineVO[]{(MaschineVO)object});
			   }
			   return null;
		   }

		   public  ValueObjWithErrLog unenableMaschineVO(Object object) throws BusinessException{
			   IMaschineMaintain operator = (IMaschineMaintain)NCLocator.getInstance().lookup(IMaschineMaintain.class);
			   if(object instanceof MaschineVO[]){
				   return operator.unenableMaschine((MaschineVO[])object);
			   }else if(object instanceof MaschineVO){
				   return operator.unenableMaschine(new MaschineVO[]{(MaschineVO)object});
			   }
			   return null;
		   }

		   public ValueObjWithErrLog disableMaschineVO(Object object) throws BusinessException{
			   IMaschineMaintain operator = (IMaschineMaintain)NCLocator.getInstance().lookup(IMaschineMaintain.class);
			   if(object instanceof MaschineVO[]){
				   return operator.disableMaschine((MaschineVO[])object);
			   }else if(object instanceof MaschineVO){
				   return operator.disableMaschine(new MaschineVO[]{(MaschineVO)object});
			   }
			   return null;
		   }
/*    */ }