package desk.sample;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/** SQL����C���^�[�t�F�[�X
 * @author none
 **/
@Mapper
public interface SqlOperation {
	List<ShohinMap> findAll();
}
