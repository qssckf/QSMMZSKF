package nc.bs.so.qs.sc.maschine.rule;

import java.util.ArrayList;
import java.util.List;

import nc.impl.pubapp.pattern.rule.IFilterRule;
import nc.vo.pubapp.pattern.exception.ExceptionUtils;
//import nc.vo.so.xlx.tran.DriverVO;
import nc.vo.so.qs.sc.MaschineVO;

public class MaschineDisableStatusFilterRule1 implements IFilterRule<MaschineVO> {

	@Override
	public MaschineVO[] process(MaschineVO[] vos) {
		// TODO 自动生成的方法存根
		MaschineVO[] dvos=filterVOByVOState(vos);
		
		if((dvos==null) || (dvos.length==0)){
			ExceptionUtils.wrappBusinessException("没有满足停用条件的记录！");
		}
		
		return dvos;
	}
	
	private MaschineVO[] filterVOByVOState(MaschineVO[] vos) {
		
		List<MaschineVO> list=new ArrayList();
		for(MaschineVO vo:vos){
			if("1".equals(vo.getMstatus())){
				list.add(vo);
			}
		}
		
		if((list.size()==0)){
			return null;
		}else{
			return list.toArray(new MaschineVO[vos.length]);
		}
		
		
	}

}
