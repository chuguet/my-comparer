package comparer.synchro.reader.readerbookmaker.convert.core;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.convert.config.ConvertReaderBookmakerConfig;
import com.comparadorad.bet.comparer.util.commons.profile.ProfileConstant;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConvertReaderBookmakerConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles(ProfileConstant.TEST)
public abstract class AbstractTest {

}
