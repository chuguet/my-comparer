package com.comparadorad.bet.comparer.web.server.mvc.livebet.control;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.junit.Test;
import org.springframework.test.web.server.request.DefaultRequestBuilder;

import com.comparadorad.bet.comparer.model.config.bean.CfgBetType;
import com.comparadorad.bet.comparer.model.config.bean.CfgBetType.CfgBetTypeId;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseCellTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseRowTo;
import com.comparadorad.bet.comparer.web.client.gwt.common.bean.table.TableResponseTo;
import com.comparadorad.bet.comparer.web.client.gwt.livebet.bean.request.LiveBetRequestTo;

public class LiveBetControllerTest extends AbstractLiveBetMvcControllerTest {

	 @Test
	 public final void testGetLiveBet() throws Exception {
	//
	// Calendar cal = Calendar.getInstance();
	// cal.set(Calendar.YEAR, 2012);
	// cal.set(Calendar.MONTH, 10); // Noviembre (meses: 0-11)
	// cal.set(Calendar.DAY_OF_MONTH, 7);
	// cal.set(Calendar.HOUR_OF_DAY, 6);
	// Date date = cal.getTime();
	// LiveBetRequestTo request = new LiveBetRequestTo();
	// request.setDate(date);
	//
	// DefaultRequestBuilder requestBuilder = postJson(
	// "/liveBetController/getLiveBet", null);
	// ObjectMapper mapper = new ObjectMapper();
	// JavaType type = mapper.getTypeFactory().constructCollectionType(
	// List.class, TableResponseTo.class);
	// List<TableResponseTo> list = mapper.readValue(
	// super.perform(requestBuilder).andReturn().getResponse()
	// .getContentAsString(), type);
	// list.toArray();
	//
	// for (TableResponseTo table : list) {
	//
	// // Controlar que la tabla viene con id y rows
	// assertNotNull(table.getObjectToId());
	// assertNotNull(table.getObjectToId().getId());
	// assertNotNull(table.getRows());
	//
	// // Fila 0 - debe tener 3 celdas
	// TableResponseRowTo row0 = table.getRows().get(0);
	// assertNotNull(row0.getCellList());
	// assertEquals(row0.getCellList().size(), 3);
	//
	// // Fila 0, Celda 0 - Fecha
	// assertNotNull(row0.getCellList().get(0).getValueTo());
	// assertNotNull(row0.getCellList().get(0).getValueTo().getDate());
	//
	// // Fila 0, Celda 1 - Fecha
	// assertNotNull(row0.getCellList().get(1).getValueTo());
	// assertNotNull(row0.getCellList().get(1).getValueTo().getDate());
	//
	// // Fila 0, Celda 2 - Tipo de apuesta
	// // Verificar que es de tipo 1X2 o Ganador Partido
	// TableResponseCellTo cell2InRow0 = row0.getCellList().get(2);
	// assertNotNull(cell2InRow0.getValueTo());
	// assertNotNull(cell2InRow0.getValueTo().getValueStr());
	// assertTrue(cell2InRow0.getValueTo().getValueStr()
	// .equalsIgnoreCase("1 x 2")
	// || cell2InRow0.getValueTo().getValueStr()
	// .equalsIgnoreCase("Ganador de partido"));
	// if (cell2InRow0.getValueTo().getValueStr().equalsIgnoreCase("1X2")) {
	// assertEquals(table.getRows().size(), 5);
	// } else if (cell2InRow0.getValueTo().getValueStr()
	// .equalsIgnoreCase("Ganador de partido")) {
	// assertEquals(table.getRows().size(), 4);
	// }
	//
	// // Fila 1 - debe tener 1 celda con Internal Link
	// TableResponseRowTo row1 = table.getRows().get(1);
	// assertNotNull(row1.getCellList());
	// assertNotNull(row1.getCellList().get(0));
	// assertNotNull(row1.getCellList().get(0).getLinkTo());
	// assertNotNull(row1.getCellList().get(0).getLinkTo().getName());
	// assertNotNull(row1.getCellList().get(0).getLinkTo().getObjectToId());
	// assertNotNull(row1.getCellList().get(0).getLinkTo().getObjectToId()
	// .getId());
	// assertNotNull(row1.getCellList().get(0).getLinkTo().getObjectToIdAux());
	// assertNotNull(row1.getCellList().get(0).getLinkTo().getObjectToIdAux().getId());
	//
	// // Fila 2, 3 (y 4 en el caso de 1X2)
	// for (int rowNum = 2; rowNum < table.getRows().size(); rowNum++) {
	// TableResponseRowTo row = table.getRows().get(rowNum);
	// assertNotNull(row.getCellList());
	// assertEquals(row.getCellList().size(), 4);
	//
	// // Celda 0 - ValueStr o Literal
	// assertNotNull(row.getCellList().get(0).getValueTo());
	// assertTrue(row.getCellList().get(0).getValueTo().getValueStr() !=
	// null
	// || row.getCellList().get(0).getValueTo().getLiteral() != null);
	//
	// // Celda 1 - ValueStr
	// assertNotNull(row.getCellList().get(1).getValueTo());
	// assertNotNull(row.getCellList().get(1).getValueTo()
	// .getValueStr());
	//
	// // Celda 2 - External link con imagen
	// assertNotNull(row.getCellList().get(2).getExternalLinkTo());
	// assertNotNull(row.getCellList().get(2).getExternalLinkTo()
	// .getLinkImgLocation());
	//
	// // Celda 3 - ValueStr
	// assertNotNull(row.getCellList().get(3).getValueTo());
	// assertNotNull(row.getCellList().get(3).getValueTo()
	// .getValueStr());
	// }
	// }
	 }

//	@Test
//	public final void getMinimalNumberOfBookmakersTest() throws Exception {
//		 DefaultRequestBuilder requestBuilder = postJson(
//		 "/liveBetController/getLiveBet",null);
//		 super.perform(requestBuilder).andDo(print()).andExpect(status().isOk());
//	}

}
