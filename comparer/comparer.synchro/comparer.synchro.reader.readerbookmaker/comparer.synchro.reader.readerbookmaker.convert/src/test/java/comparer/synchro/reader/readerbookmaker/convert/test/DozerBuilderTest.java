package comparer.synchro.reader.readerbookmaker.convert.test;
import static org.dozer.loader.api.TypeMappingOptions.mapId;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.comparadorad.bet.comparer.synchro.reader.model.XmlMatch;
import com.comparadorad.bet.comparer.synchro.reader.model.XmlSport;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betclick.Event;
import com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.betclick.Sport;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InitClass.class, loader = AnnotationConfigContextLoader.class)
public class DozerBuilderTest {

	private static final String FILE_CONFIGURATION_DOZER = "dozer-bean-test-mappings.xml";
	@Inject
	private DozerBeanMapper mapper;

	@Test
	public void testApi() {

		mapper.addMapping(getBuilder(Sport.class, XmlSport.class, "name",
				"name"));

		// CustomConverter cc =
		// mapper.getCustomConvertersWithId().get("convert1");
		// cc.convert(arg0, arg1, arg2, arg3)
		Sport sport = new Sport();
		sport.setName("Football");

		XmlSport xmlSport = mapper.map(sport, XmlSport.class);
		System.out.println(xmlSport.getName());
	}

	private BeanMappingBuilder getBuilder(final Class<?> class1,
			final Class<?> class2, final String param1, final String param2) {
		BeanMappingBuilder builder = new BeanMappingBuilder() {
			protected void configure() {
				mapping(class1, class2, mapId("A")).fields(param1, param2);

			}
		};
		return builder;
	}

	@Test
	public void testXML() {

		List<String> mappingFileUrls = new ArrayList<String>();
		mappingFileUrls.add(FILE_CONFIGURATION_DOZER);
		mapper.setMappingFiles(mappingFileUrls);
		Event event = new Event();
		event.setName("World Cup");
		XmlMatch xmlmatch = mapper.map(event, XmlMatch.class);
		System.out.println(xmlmatch.getName());
	}

}