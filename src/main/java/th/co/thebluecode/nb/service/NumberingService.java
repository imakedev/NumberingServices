package th.co.thebluecode.nb.service;

import org.springframework.dao.DataAccessException;
import th.co.thebluecode.nb.model.PhoneCheckM;
import th.co.thebluecode.nb.xstream.common.ImakeMessage;
import th.co.thebluecode.nb.xstream.common.ImakeResultMessage;

import java.util.List;

public interface NumberingService {
    public ImakeResultMessage listNumber(PhoneCheckM phoneCheck) throws DataAccessException;
    public ImakeMessage updateNumber(List<PhoneCheckM> phoneChecks)throws DataAccessException;

}
