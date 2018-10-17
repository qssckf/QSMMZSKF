package nc.ui.so.qs.sc.maschine.service;
/*    */ 
/*    */ import nc.bs.framework.common.NCLocator;
///*    */ import nc.itf.pd.pd0404.IPDWkQuery;
		import nc.itf.so.qs.sc.maschine.service.IMaschineQuery;
/*    */ import nc.ui.pubapp.uif2app.query2.model.IQueryService;
/*    */ import nc.ui.querytemplate.querytree.IQueryScheme;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MaschineQueryService
/*    */   implements IQueryService
/*    */ {
/*    */   public MaschineQueryService() {}
/*    */   
/*    */   public Object[] queryByQueryScheme(IQueryScheme queryScheme)
/*    */     throws Exception
/*    */   {
/* 19 */     return ((IMaschineQuery)NCLocator.getInstance().lookup(IMaschineQuery.class)).queryByQueryScheme(queryScheme);
/*    */   }
/*    */ }
