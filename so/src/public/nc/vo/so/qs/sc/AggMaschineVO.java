  /***************************************************************\
  *     The skeleton of this class is generated by an automatic *
  * code generator for NC product. It is based on Velocity.     *
  \***************************************************************/

package nc.vo.so.qs.sc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import nc.vo.pd.pd0404.entity.WkProdinvVO;
import nc.vo.pd.pd0404.entity.WkRepltimeVO;
import nc.vo.pd.pd0404.entity.WkSubstVO;
import nc.vo.pd.pd0404.entity.WkVO;
import nc.vo.pd.pd0404.entity.WkWipVO;
import nc.vo.pub.CircularlyAccessibleValueObject;
import nc.vo.pub.IVOMeta;
import nc.vo.pub.SuperVO;
import nc.vo.pubapp.pattern.model.entity.bill.AbstractBill;
import nc.vo.pubapp.pattern.model.meta.entity.bill.AbstractBillMeta;
import nc.vo.pubapp.pattern.model.meta.entity.bill.BillMetaFactory;
import nc.vo.pubapp.pattern.model.meta.entity.bill.IBillMeta;
import nc.vo.pubapp.pattern.model.meta.entity.vo.VOMetaFactory;
import nc.vo.trade.pub.IExAggVO;
import nc.vo.trade.pub.HYBillVO;


/**
 * 
 * 该类是用于多子表的聚合VO
 *
 * 创建日期:
 * @author 
 * @version NCPrj ??
 */
@SuppressWarnings("serial")
@nc.vo.annotation.AggVoInfo(parentVO = "nc.vo.so.qs.sc.MaschineVO")
public class AggMaschineVO extends AbstractBill implements IExAggVO{
    
	
	//用于装载多子表数据的HashMap
	private HashMap hmChildVOs = new HashMap();
	
	
	/**
	 * 返回多个子表的编码
	 * 必须与单据模版的页签编码对应
	 * 创建日期：
	 * @return String[]
	 */
	public String[] getTableCodes(){
		          
		return new String[]{
		 		 		   		"machine_material",
		   		 		   		"machine_customer",
		   		 		   		"machine_dept"
		   		    };
		          
	}
	
	
	/**
	 * 返回多个子表的中文名称
	 * 创建日期：
	 * @return String[]
	 */
	public String[] getTableNames(){
		
		return new String[]{
                                           "机器所加工物料",
                                            "机器所属客户",
                                            "机器所属部门",
                         };
	}
	
	
	/**
	 * 取得所有子表的所有VO对象
	 * 创建日期：
	 * @return CircularlyAccessibleValueObject[]
	 */
	public CircularlyAccessibleValueObject[] getAllChildrenVO(){
		
		ArrayList al = new ArrayList();
		for(int i = 0; i < getTableCodes().length; i++){
			CircularlyAccessibleValueObject[] cvos
			        = getTableVO(getTableCodes()[i]);
			if(cvos != null)
				al.addAll(Arrays.asList(cvos));
		}
		
		return (SuperVO[]) al.toArray(new SuperVO[0]);
	}
	
	
	/**
	 * 返回每个子表的VO数组
	 * 创建日期：
	 * @return CircularlyAccessibleValueObject[]
	 */
	public CircularlyAccessibleValueObject[] getTableVO(String tableCode){
		
		return (CircularlyAccessibleValueObject[])
		            hmChildVOs.get(tableCode);
	}
	
	
	/**
	 * 
	 * 创建日期：
	 * @param SuperVO item
	 * @param String id
	 */
	public void setParentId(SuperVO item,String id){}
	
	/**
	 * 为特定子表设置VO数据
	 * 创建日期：
	 * @param String tableCode
	 * @para CircularlyAccessibleValueObject[] vos
	 */
	public void setTableVO(String tableCode,CircularlyAccessibleValueObject[] vos){
		
		hmChildVOs.put(tableCode,vos);
	}
	
	/**
	 * 缺省的页签编码
	 * 创建日期：
	 * @return String 
	 */
	public String getDefaultTableCode(){
		
		return getTableCodes()[0];
	}
	

	@Override
	public CircularlyAccessibleValueObject[] getChildrenVO() {
		// TODO 自动生成的方法存根
		ArrayList<CircularlyAccessibleValueObject> al = new ArrayList();
		for (int i = 0; i < getTableCodes().length; i++) {
		  CircularlyAccessibleValueObject[] cvos = getTableVO(getTableCodes()[i]);
		  if (cvos != null) {
		    al.addAll(Arrays.asList(cvos));
		  }
		}
		return (CircularlyAccessibleValueObject[])al.toArray(new SuperVO[0]);
	}


	@Override
	public IBillMeta getMetaData() {
		// TODO 自动生成的方法存根
	  	return new AggMaschineMeta();
	}
	
	
	
	public class AggMaschineMeta extends AbstractBillMeta
	{
	   public AggMaschineMeta()
	   {
	     setParent(MaschineVO.class);
	     addChildren(MachineCustomer.class);
	     addChildren(MachineDept.class);
	     addChildren(MachineMater_Mater.class);
	     IVOMeta cust_meta = VOMetaFactory.getInstance().getVOMeta("so.MachineCustomer");
	     addChildForeignKey(cust_meta.getAttribute("machine_customer"));
	     IVOMeta dept_meta = VOMetaFactory.getInstance().getVOMeta("so.MachineDept");
	     addChildForeignKey(dept_meta.getAttribute("machine_dept"));
	     IVOMeta mater_meta = VOMetaFactory.getInstance().getVOMeta("so.MachineMater");
	     addChildForeignKey(mater_meta.getAttribute("machine_material"));
	   }
	 }
	  public MaschineVO getParentVO(){
		  	return (MaschineVO)this.getParent();
		  }
}
