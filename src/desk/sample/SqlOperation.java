package desk.sample;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/** SQL操作インターフェース
 * @author none
 **/
@Mapper
public interface SqlOperation {
	List<ShohinMap> findAll();
}
