package nc.bs.so.qs.sc.maschine.bp;

//import nc.bs.pd.pd0404.plugin.bpplugin.PDWkPluginPoint;
//import nc.bs.pd.pd0404.rule.PDWkCheckRefWhenDelRule;
//import nc.bs.pd.pd0404.rule.PDWkDeleteAfterEventRule;
//import nc.bs.pd.pd0404.rule.PDWkDeleteBeforeEventRule;
//import nc.bs.pd.pd0404.rule.PDWkDeleteCacheMaintainRule;
import nc.bs.bd.bp.rule.BDPKLockSuperVORule;
import nc.bs.bd.bp.rule.BizLockRule;
import nc.bs.bd.bp.rule.FireEventRule;
import nc.bs.bd.bp.rule.VersionValidateRule;
import nc.bs.bd.bp.rule.WriteBusiLogRule;
import nc.bs.bd.bp.rule.delete.BDReferenceCheckerRule;
import nc.bs.bd.bp.rule.delete.NotifyVersionChangeWhenDataDeletedRule;
import nc.bs.so.qs.sc.maschine.plugin.bpplugin.MaschinePluginPoint;
import nc.impl.pubapp.pattern.data.bill.template.DeleteBPTemplate;
import nc.impl.pubapp.pattern.rule.IRule;
import nc.impl.pubapp.pattern.rule.processer.AroundProcesser;
import nc.util.mmf.framework.base.MMArrayUtil;
//import nc.vo.pd.pd0404.entity.AggWkVO;
import nc.vo.so.qs.sc.AggMaschineVO;










public class MaschineDeleteBP
{
  public MaschineDeleteBP() {}
  
  public void delete(AggMaschineVO[] vos)
  {
    if (MMArrayUtil.isEmpty(vos)) {
      return;
    }
    DeleteBPTemplate<AggMaschineVO> bp = new DeleteBPTemplate(MaschinePluginPoint.DELETE);
    
    addBeforeRule(bp.getAroundProcesser());
    
    addAfterRule(bp.getAroundProcesser());
    bp.delete(vos);
  }
  






  private void addBeforeRule(AroundProcesser<AggMaschineVO> processer)
  {
//    IRule<AggMaschineVO> beforeventrule = new PDWkDeleteBeforeEventRule();
//    processer.addBeforeRule(beforeventrule);
//    
//
//    IRule<AggMaschineVO> checkrefwhendeleterule = new PDWkCheckRefWhenDelRule();
//    processer.addBeforeRule(checkrefwhendeleterule);
		
	  processer.addBeforeRule(new BDPKLockSuperVORule());
	  processer.addBeforeRule(new BizLockRule());
	  processer.addBeforeRule(new VersionValidateRule());
	  processer.addBeforeRule(new BDReferenceCheckerRule());
	  processer.addBeforeRule(new FireEventRule("1005"));
	  processer.addBeforeRule(new NotifyVersionChangeWhenDataDeletedRule());
  }
  






  private void addAfterRule(AroundProcesser<AggMaschineVO> processer)
  {
//    IRule<AggMaschineVO> aftereventrule = new PDWkDeleteAfterEventRule();
//    processer.addAfterRule(aftereventrule);
//    IRule<AggMaschineVO> cacherule = new PDWkDeleteCacheMaintainRule();
//    processer.addAfterRule(cacherule);
	  
		
	  processer.addAfterRule(new FireEventRule("1006"));
		
	  processer.addAfterRule(new WriteBusiLogRule("delete"));
  }
}
