//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.6 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: PM.05.23 a las 02:06:29 PM CEST 
//


package com.comparadorad.bet.comparer.synchro.reader.readerbookmaker.bean.bluesquare;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Occurrence" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attribute name="sp_avail" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="N"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="mkt_typ" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Correct Score"/>
 *             &lt;enumeration value="Double Chance"/>
 *             &lt;enumeration value="Double Handicap"/>
 *             &lt;enumeration value="Draw No Bet"/>
 *             &lt;enumeration value="Easy Money Doubles"/>
 *             &lt;enumeration value="First Goal Method"/>
 *             &lt;enumeration value="First Goalscorer"/>
 *             &lt;enumeration value="Goal Crazy"/>
 *             &lt;enumeration value="Goalscorer Match Bet"/>
 *             &lt;enumeration value="Half With Most Goals"/>
 *             &lt;enumeration value="Half-Time Correct Score"/>
 *             &lt;enumeration value="Half-Time Result"/>
 *             &lt;enumeration value="Half-Time/Full-Time"/>
 *             &lt;enumeration value="Handicap"/>
 *             &lt;enumeration value="How will the match be won?"/>
 *             &lt;enumeration value="Last Goalscorer"/>
 *             &lt;enumeration value="Man of the Match"/>
 *             &lt;enumeration value="Outright"/>
 *             &lt;enumeration value="Player Specials"/>
 *             &lt;enumeration value="Player to Score"/>
 *             &lt;enumeration value="Reverse Handicap"/>
 *             &lt;enumeration value="Score/Win Double"/>
 *             &lt;enumeration value="Team Goals"/>
 *             &lt;enumeration value="Team Specials"/>
 *             &lt;enumeration value="Team to Score First"/>
 *             &lt;enumeration value="Teams to Score"/>
 *             &lt;enumeration value="Time of First Goal"/>
 *             &lt;enumeration value="Time of First Goal (Brackets)"/>
 *             &lt;enumeration value="To Win The Champions League"/>
 *             &lt;enumeration value="To score 2 or more goals"/>
 *             &lt;enumeration value="To score a hat-trick"/>
 *             &lt;enumeration value="Total Goal Minutes"/>
 *             &lt;enumeration value="Total Goals"/>
 *             &lt;enumeration value="Total Goals Over/Under"/>
 *             &lt;enumeration value="Win/Draw/Win"/>
 *             &lt;enumeration value="Winning Margins"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="mkt_id" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;enumeration value="12949541"/>
 *             &lt;enumeration value="12949542"/>
 *             &lt;enumeration value="12949598"/>
 *             &lt;enumeration value="12949599"/>
 *             &lt;enumeration value="12949600"/>
 *             &lt;enumeration value="12949601"/>
 *             &lt;enumeration value="12949602"/>
 *             &lt;enumeration value="12949603"/>
 *             &lt;enumeration value="12949604"/>
 *             &lt;enumeration value="12949605"/>
 *             &lt;enumeration value="12949606"/>
 *             &lt;enumeration value="12949607"/>
 *             &lt;enumeration value="12949608"/>
 *             &lt;enumeration value="12949609"/>
 *             &lt;enumeration value="12949610"/>
 *             &lt;enumeration value="12949611"/>
 *             &lt;enumeration value="12949612"/>
 *             &lt;enumeration value="12949613"/>
 *             &lt;enumeration value="12949614"/>
 *             &lt;enumeration value="12949615"/>
 *             &lt;enumeration value="12949616"/>
 *             &lt;enumeration value="12949617"/>
 *             &lt;enumeration value="12949618"/>
 *             &lt;enumeration value="12949619"/>
 *             &lt;enumeration value="12949620"/>
 *             &lt;enumeration value="13074783"/>
 *             &lt;enumeration value="13131457"/>
 *             &lt;enumeration value="13131458"/>
 *             &lt;enumeration value="13131459"/>
 *             &lt;enumeration value="13131460"/>
 *             &lt;enumeration value="13131461"/>
 *             &lt;enumeration value="13131462"/>
 *             &lt;enumeration value="13131463"/>
 *             &lt;enumeration value="13131464"/>
 *             &lt;enumeration value="13131465"/>
 *             &lt;enumeration value="13131466"/>
 *             &lt;enumeration value="13131467"/>
 *             &lt;enumeration value="13131468"/>
 *             &lt;enumeration value="13131469"/>
 *             &lt;enumeration value="13131470"/>
 *             &lt;enumeration value="13131471"/>
 *             &lt;enumeration value="13131472"/>
 *             &lt;enumeration value="13131473"/>
 *             &lt;enumeration value="13131483"/>
 *             &lt;enumeration value="13132365"/>
 *             &lt;enumeration value="13132368"/>
 *             &lt;enumeration value="13132373"/>
 *             &lt;enumeration value="13132375"/>
 *             &lt;enumeration value="13132388"/>
 *             &lt;enumeration value="13132733"/>
 *             &lt;enumeration value="13132734"/>
 *             &lt;enumeration value="13132735"/>
 *             &lt;enumeration value="13132736"/>
 *             &lt;enumeration value="13132737"/>
 *             &lt;enumeration value="13132738"/>
 *             &lt;enumeration value="13132739"/>
 *             &lt;enumeration value="13132740"/>
 *             &lt;enumeration value="13132741"/>
 *             &lt;enumeration value="13132742"/>
 *             &lt;enumeration value="13132743"/>
 *             &lt;enumeration value="13132744"/>
 *             &lt;enumeration value="13132745"/>
 *             &lt;enumeration value="13132746"/>
 *             &lt;enumeration value="13132747"/>
 *             &lt;enumeration value="13132748"/>
 *             &lt;enumeration value="13132749"/>
 *             &lt;enumeration value="13132750"/>
 *             &lt;enumeration value="13132751"/>
 *             &lt;enumeration value="13132752"/>
 *             &lt;enumeration value="13132753"/>
 *             &lt;enumeration value="13132754"/>
 *             &lt;enumeration value="13132755"/>
 *             &lt;enumeration value="13135508"/>
 *             &lt;enumeration value="13135509"/>
 *             &lt;enumeration value="13135510"/>
 *             &lt;enumeration value="13135511"/>
 *             &lt;enumeration value="13135512"/>
 *             &lt;enumeration value="13135513"/>
 *             &lt;enumeration value="13135587"/>
 *             &lt;enumeration value="13135675"/>
 *             &lt;enumeration value="13135676"/>
 *             &lt;enumeration value="13135677"/>
 *             &lt;enumeration value="13135678"/>
 *             &lt;enumeration value="13135679"/>
 *             &lt;enumeration value="13135680"/>
 *             &lt;enumeration value="13135681"/>
 *             &lt;enumeration value="13135682"/>
 *             &lt;enumeration value="13135683"/>
 *             &lt;enumeration value="13135684"/>
 *             &lt;enumeration value="13136087"/>
 *             &lt;enumeration value="13136088"/>
 *             &lt;enumeration value="13139804"/>
 *             &lt;enumeration value="13139805"/>
 *             &lt;enumeration value="13139808"/>
 *             &lt;enumeration value="13139809"/>
 *             &lt;enumeration value="13139812"/>
 *             &lt;enumeration value="13139813"/>
 *             &lt;enumeration value="13139816"/>
 *             &lt;enumeration value="13139817"/>
 *             &lt;enumeration value="13139820"/>
 *             &lt;enumeration value="13139821"/>
 *             &lt;enumeration value="13139824"/>
 *             &lt;enumeration value="13139825"/>
 *             &lt;enumeration value="13141175"/>
 *             &lt;enumeration value="13141178"/>
 *             &lt;enumeration value="13141179"/>
 *             &lt;enumeration value="13141180"/>
 *             &lt;enumeration value="13141183"/>
 *             &lt;enumeration value="13141187"/>
 *             &lt;enumeration value="13141188"/>
 *             &lt;enumeration value="13141189"/>
 *             &lt;enumeration value="13141190"/>
 *             &lt;enumeration value="13141191"/>
 *             &lt;enumeration value="13141204"/>
 *             &lt;enumeration value="13142205"/>
 *             &lt;enumeration value="13142206"/>
 *             &lt;enumeration value="13142554"/>
 *             &lt;enumeration value="13142555"/>
 *             &lt;enumeration value="13142556"/>
 *             &lt;enumeration value="13142557"/>
 *             &lt;enumeration value="13142558"/>
 *             &lt;enumeration value="13142559"/>
 *             &lt;enumeration value="13142560"/>
 *             &lt;enumeration value="13142561"/>
 *             &lt;enumeration value="13142562"/>
 *             &lt;enumeration value="13142563"/>
 *             &lt;enumeration value="13142564"/>
 *             &lt;enumeration value="13142565"/>
 *             &lt;enumeration value="13142566"/>
 *             &lt;enumeration value="13142567"/>
 *             &lt;enumeration value="13142568"/>
 *             &lt;enumeration value="13142569"/>
 *             &lt;enumeration value="13142570"/>
 *             &lt;enumeration value="13142571"/>
 *             &lt;enumeration value="13142572"/>
 *             &lt;enumeration value="13142573"/>
 *             &lt;enumeration value="13142574"/>
 *             &lt;enumeration value="13142575"/>
 *             &lt;enumeration value="13142576"/>
 *             &lt;enumeration value="13142577"/>
 *             &lt;enumeration value="13142578"/>
 *             &lt;enumeration value="13142579"/>
 *             &lt;enumeration value="13142580"/>
 *             &lt;enumeration value="13142581"/>
 *             &lt;enumeration value="13142582"/>
 *             &lt;enumeration value="13142583"/>
 *             &lt;enumeration value="13142584"/>
 *             &lt;enumeration value="13142585"/>
 *             &lt;enumeration value="13142586"/>
 *             &lt;enumeration value="13142587"/>
 *             &lt;enumeration value="13142588"/>
 *             &lt;enumeration value="13142589"/>
 *             &lt;enumeration value="13142590"/>
 *             &lt;enumeration value="13142591"/>
 *             &lt;enumeration value="13142592"/>
 *             &lt;enumeration value="13142593"/>
 *             &lt;enumeration value="13142594"/>
 *             &lt;enumeration value="13142595"/>
 *             &lt;enumeration value="13142596"/>
 *             &lt;enumeration value="13142597"/>
 *             &lt;enumeration value="13142598"/>
 *             &lt;enumeration value="13142599"/>
 *             &lt;enumeration value="13142600"/>
 *             &lt;enumeration value="13142601"/>
 *             &lt;enumeration value="13142602"/>
 *             &lt;enumeration value="13142603"/>
 *             &lt;enumeration value="13142604"/>
 *             &lt;enumeration value="13142605"/>
 *             &lt;enumeration value="13142606"/>
 *             &lt;enumeration value="13142607"/>
 *             &lt;enumeration value="13142608"/>
 *             &lt;enumeration value="13142609"/>
 *             &lt;enumeration value="13142610"/>
 *             &lt;enumeration value="13142611"/>
 *             &lt;enumeration value="13142612"/>
 *             &lt;enumeration value="13142613"/>
 *             &lt;enumeration value="13142614"/>
 *             &lt;enumeration value="13142615"/>
 *             &lt;enumeration value="13142616"/>
 *             &lt;enumeration value="13142617"/>
 *             &lt;enumeration value="13142618"/>
 *             &lt;enumeration value="13142619"/>
 *             &lt;enumeration value="13142620"/>
 *             &lt;enumeration value="13142621"/>
 *             &lt;enumeration value="13142622"/>
 *             &lt;enumeration value="13142623"/>
 *             &lt;enumeration value="13142624"/>
 *             &lt;enumeration value="13142625"/>
 *             &lt;enumeration value="13142626"/>
 *             &lt;enumeration value="13142627"/>
 *             &lt;enumeration value="13142628"/>
 *             &lt;enumeration value="13142629"/>
 *             &lt;enumeration value="13142630"/>
 *             &lt;enumeration value="13142631"/>
 *             &lt;enumeration value="13142632"/>
 *             &lt;enumeration value="13142633"/>
 *             &lt;enumeration value="13142634"/>
 *             &lt;enumeration value="13142635"/>
 *             &lt;enumeration value="13142636"/>
 *             &lt;enumeration value="13142637"/>
 *             &lt;enumeration value="13142638"/>
 *             &lt;enumeration value="13142639"/>
 *             &lt;enumeration value="13142640"/>
 *             &lt;enumeration value="13142641"/>
 *             &lt;enumeration value="13142642"/>
 *             &lt;enumeration value="13142643"/>
 *             &lt;enumeration value="13142644"/>
 *             &lt;enumeration value="13142645"/>
 *             &lt;enumeration value="13142646"/>
 *             &lt;enumeration value="13142647"/>
 *             &lt;enumeration value="13142648"/>
 *             &lt;enumeration value="13142649"/>
 *             &lt;enumeration value="13142650"/>
 *             &lt;enumeration value="13142651"/>
 *             &lt;enumeration value="13142652"/>
 *             &lt;enumeration value="13142653"/>
 *             &lt;enumeration value="13142654"/>
 *             &lt;enumeration value="13142655"/>
 *             &lt;enumeration value="13142656"/>
 *             &lt;enumeration value="13142657"/>
 *             &lt;enumeration value="13142658"/>
 *             &lt;enumeration value="13142659"/>
 *             &lt;enumeration value="13142660"/>
 *             &lt;enumeration value="13142661"/>
 *             &lt;enumeration value="13142662"/>
 *             &lt;enumeration value="13142663"/>
 *             &lt;enumeration value="13142664"/>
 *             &lt;enumeration value="13142665"/>
 *             &lt;enumeration value="13142666"/>
 *             &lt;enumeration value="13142667"/>
 *             &lt;enumeration value="13142668"/>
 *             &lt;enumeration value="13142669"/>
 *             &lt;enumeration value="13142670"/>
 *             &lt;enumeration value="13142671"/>
 *             &lt;enumeration value="13142672"/>
 *             &lt;enumeration value="13142673"/>
 *             &lt;enumeration value="13142674"/>
 *             &lt;enumeration value="13142675"/>
 *             &lt;enumeration value="13142676"/>
 *             &lt;enumeration value="13142677"/>
 *             &lt;enumeration value="13142678"/>
 *             &lt;enumeration value="13142679"/>
 *             &lt;enumeration value="13142680"/>
 *             &lt;enumeration value="13142681"/>
 *             &lt;enumeration value="13142682"/>
 *             &lt;enumeration value="13142683"/>
 *             &lt;enumeration value="13142684"/>
 *             &lt;enumeration value="13142685"/>
 *             &lt;enumeration value="13142686"/>
 *             &lt;enumeration value="13142687"/>
 *             &lt;enumeration value="13142688"/>
 *             &lt;enumeration value="13142689"/>
 *             &lt;enumeration value="13142914"/>
 *             &lt;enumeration value="13142915"/>
 *             &lt;enumeration value="13142916"/>
 *             &lt;enumeration value="13142917"/>
 *             &lt;enumeration value="13142918"/>
 *             &lt;enumeration value="13142919"/>
 *             &lt;enumeration value="13142920"/>
 *             &lt;enumeration value="13142921"/>
 *             &lt;enumeration value="13142922"/>
 *             &lt;enumeration value="13142923"/>
 *             &lt;enumeration value="13142924"/>
 *             &lt;enumeration value="13142925"/>
 *             &lt;enumeration value="13142926"/>
 *             &lt;enumeration value="13142927"/>
 *             &lt;enumeration value="13142928"/>
 *             &lt;enumeration value="13142929"/>
 *             &lt;enumeration value="13142930"/>
 *             &lt;enumeration value="13142931"/>
 *             &lt;enumeration value="13142932"/>
 *             &lt;enumeration value="13142933"/>
 *             &lt;enumeration value="13142934"/>
 *             &lt;enumeration value="13142935"/>
 *             &lt;enumeration value="13143570"/>
 *             &lt;enumeration value="13143571"/>
 *             &lt;enumeration value="13143572"/>
 *             &lt;enumeration value="13143573"/>
 *             &lt;enumeration value="13143574"/>
 *             &lt;enumeration value="13143575"/>
 *             &lt;enumeration value="13145371"/>
 *             &lt;enumeration value="13145372"/>
 *             &lt;enumeration value="13145373"/>
 *             &lt;enumeration value="13145374"/>
 *             &lt;enumeration value="13145375"/>
 *             &lt;enumeration value="13145376"/>
 *             &lt;enumeration value="13145892"/>
 *             &lt;enumeration value="13147008"/>
 *             &lt;enumeration value="13147009"/>
 *             &lt;enumeration value="13147010"/>
 *             &lt;enumeration value="13147446"/>
 *             &lt;enumeration value="13147448"/>
 *             &lt;enumeration value="13147449"/>
 *             &lt;enumeration value="13147451"/>
 *             &lt;enumeration value="13147452"/>
 *             &lt;enumeration value="13147454"/>
 *             &lt;enumeration value="13147455"/>
 *             &lt;enumeration value="13147457"/>
 *             &lt;enumeration value="13147458"/>
 *             &lt;enumeration value="13147460"/>
 *             &lt;enumeration value="13147461"/>
 *             &lt;enumeration value="13147463"/>
 *             &lt;enumeration value="13147465"/>
 *             &lt;enumeration value="13147466"/>
 *             &lt;enumeration value="13147467"/>
 *             &lt;enumeration value="13148013"/>
 *             &lt;enumeration value="13148014"/>
 *             &lt;enumeration value="13148015"/>
 *             &lt;enumeration value="13148016"/>
 *             &lt;enumeration value="13148017"/>
 *             &lt;enumeration value="13148018"/>
 *             &lt;enumeration value="13148019"/>
 *             &lt;enumeration value="13148020"/>
 *             &lt;enumeration value="13153889"/>
 *             &lt;enumeration value="13153890"/>
 *             &lt;enumeration value="13153891"/>
 *             &lt;enumeration value="13153892"/>
 *             &lt;enumeration value="13153893"/>
 *             &lt;enumeration value="13153894"/>
 *             &lt;enumeration value="13153895"/>
 *             &lt;enumeration value="13153896"/>
 *             &lt;enumeration value="13153897"/>
 *             &lt;enumeration value="13153898"/>
 *             &lt;enumeration value="13154009"/>
 *             &lt;enumeration value="13154057"/>
 *             &lt;enumeration value="13154067"/>
 *             &lt;enumeration value="13154068"/>
 *             &lt;enumeration value="13154069"/>
 *             &lt;enumeration value="13154070"/>
 *             &lt;enumeration value="13154071"/>
 *             &lt;enumeration value="13154088"/>
 *             &lt;enumeration value="13154094"/>
 *             &lt;enumeration value="13154095"/>
 *             &lt;enumeration value="13154096"/>
 *             &lt;enumeration value="13154198"/>
 *             &lt;enumeration value="13154199"/>
 *             &lt;enumeration value="13154200"/>
 *             &lt;enumeration value="13154201"/>
 *             &lt;enumeration value="13154202"/>
 *             &lt;enumeration value="13154203"/>
 *             &lt;enumeration value="13154204"/>
 *             &lt;enumeration value="13154205"/>
 *             &lt;enumeration value="13154206"/>
 *             &lt;enumeration value="13154207"/>
 *             &lt;enumeration value="13154208"/>
 *             &lt;enumeration value="13154209"/>
 *             &lt;enumeration value="13154210"/>
 *             &lt;enumeration value="13154211"/>
 *             &lt;enumeration value="13154212"/>
 *             &lt;enumeration value="13154213"/>
 *             &lt;enumeration value="13154214"/>
 *             &lt;enumeration value="13154215"/>
 *             &lt;enumeration value="13154216"/>
 *             &lt;enumeration value="13154217"/>
 *             &lt;enumeration value="13154218"/>
 *             &lt;enumeration value="13154219"/>
 *             &lt;enumeration value="13154220"/>
 *             &lt;enumeration value="13154221"/>
 *             &lt;enumeration value="13154222"/>
 *             &lt;enumeration value="13154223"/>
 *             &lt;enumeration value="13154224"/>
 *             &lt;enumeration value="13154225"/>
 *             &lt;enumeration value="13154226"/>
 *             &lt;enumeration value="13154227"/>
 *             &lt;enumeration value="13154228"/>
 *             &lt;enumeration value="13154229"/>
 *             &lt;enumeration value="13154230"/>
 *             &lt;enumeration value="13154231"/>
 *             &lt;enumeration value="13154232"/>
 *             &lt;enumeration value="13154233"/>
 *             &lt;enumeration value="13154234"/>
 *             &lt;enumeration value="13154235"/>
 *             &lt;enumeration value="13154236"/>
 *             &lt;enumeration value="13154237"/>
 *             &lt;enumeration value="13154238"/>
 *             &lt;enumeration value="13154239"/>
 *             &lt;enumeration value="13154240"/>
 *             &lt;enumeration value="13154241"/>
 *             &lt;enumeration value="13154242"/>
 *             &lt;enumeration value="13154243"/>
 *             &lt;enumeration value="13154244"/>
 *             &lt;enumeration value="13154245"/>
 *             &lt;enumeration value="13154246"/>
 *             &lt;enumeration value="13154247"/>
 *             &lt;enumeration value="13154248"/>
 *             &lt;enumeration value="13154249"/>
 *             &lt;enumeration value="13154250"/>
 *             &lt;enumeration value="13154251"/>
 *             &lt;enumeration value="13154252"/>
 *             &lt;enumeration value="13154253"/>
 *             &lt;enumeration value="13154254"/>
 *             &lt;enumeration value="13154255"/>
 *             &lt;enumeration value="13154256"/>
 *             &lt;enumeration value="13154257"/>
 *             &lt;enumeration value="13154258"/>
 *             &lt;enumeration value="13154259"/>
 *             &lt;enumeration value="13154260"/>
 *             &lt;enumeration value="13154261"/>
 *             &lt;enumeration value="13154262"/>
 *             &lt;enumeration value="13154263"/>
 *             &lt;enumeration value="13154264"/>
 *             &lt;enumeration value="13154265"/>
 *             &lt;enumeration value="13154266"/>
 *             &lt;enumeration value="13154267"/>
 *             &lt;enumeration value="13154268"/>
 *             &lt;enumeration value="13154269"/>
 *             &lt;enumeration value="13154270"/>
 *             &lt;enumeration value="13154271"/>
 *             &lt;enumeration value="13154272"/>
 *             &lt;enumeration value="13154273"/>
 *             &lt;enumeration value="13154274"/>
 *             &lt;enumeration value="13154275"/>
 *             &lt;enumeration value="13154276"/>
 *             &lt;enumeration value="13154277"/>
 *             &lt;enumeration value="13154278"/>
 *             &lt;enumeration value="13154279"/>
 *             &lt;enumeration value="13154280"/>
 *             &lt;enumeration value="13154281"/>
 *             &lt;enumeration value="13154282"/>
 *             &lt;enumeration value="13154283"/>
 *             &lt;enumeration value="13154284"/>
 *             &lt;enumeration value="13154285"/>
 *             &lt;enumeration value="13154286"/>
 *             &lt;enumeration value="13154287"/>
 *             &lt;enumeration value="13154288"/>
 *             &lt;enumeration value="13154289"/>
 *             &lt;enumeration value="13154290"/>
 *             &lt;enumeration value="13154291"/>
 *             &lt;enumeration value="13154292"/>
 *             &lt;enumeration value="13154293"/>
 *             &lt;enumeration value="13154294"/>
 *             &lt;enumeration value="13154295"/>
 *             &lt;enumeration value="13154296"/>
 *             &lt;enumeration value="13154297"/>
 *             &lt;enumeration value="13154298"/>
 *             &lt;enumeration value="13154299"/>
 *             &lt;enumeration value="13154300"/>
 *             &lt;enumeration value="13154301"/>
 *             &lt;enumeration value="13154302"/>
 *             &lt;enumeration value="13154303"/>
 *             &lt;enumeration value="13154304"/>
 *             &lt;enumeration value="13154305"/>
 *             &lt;enumeration value="13154306"/>
 *             &lt;enumeration value="13154307"/>
 *             &lt;enumeration value="13154308"/>
 *             &lt;enumeration value="13154309"/>
 *             &lt;enumeration value="13154310"/>
 *             &lt;enumeration value="13154311"/>
 *             &lt;enumeration value="13154312"/>
 *             &lt;enumeration value="13154313"/>
 *             &lt;enumeration value="13154314"/>
 *             &lt;enumeration value="13154315"/>
 *             &lt;enumeration value="13154316"/>
 *             &lt;enumeration value="13154317"/>
 *             &lt;enumeration value="13154318"/>
 *             &lt;enumeration value="13154319"/>
 *             &lt;enumeration value="13154320"/>
 *             &lt;enumeration value="13154321"/>
 *             &lt;enumeration value="13154322"/>
 *             &lt;enumeration value="13154323"/>
 *             &lt;enumeration value="13154324"/>
 *             &lt;enumeration value="13154325"/>
 *             &lt;enumeration value="13154326"/>
 *             &lt;enumeration value="13154327"/>
 *             &lt;enumeration value="13154328"/>
 *             &lt;enumeration value="13154329"/>
 *             &lt;enumeration value="13154330"/>
 *             &lt;enumeration value="13154331"/>
 *             &lt;enumeration value="13154332"/>
 *             &lt;enumeration value="13154333"/>
 *             &lt;enumeration value="13154334"/>
 *             &lt;enumeration value="13154335"/>
 *             &lt;enumeration value="13154336"/>
 *             &lt;enumeration value="13154337"/>
 *             &lt;enumeration value="13154338"/>
 *             &lt;enumeration value="13154339"/>
 *             &lt;enumeration value="13154340"/>
 *             &lt;enumeration value="13154341"/>
 *             &lt;enumeration value="13154342"/>
 *             &lt;enumeration value="13154343"/>
 *             &lt;enumeration value="13154344"/>
 *             &lt;enumeration value="13154345"/>
 *             &lt;enumeration value="13154346"/>
 *             &lt;enumeration value="13154347"/>
 *             &lt;enumeration value="13154348"/>
 *             &lt;enumeration value="13154349"/>
 *             &lt;enumeration value="13154350"/>
 *             &lt;enumeration value="13154351"/>
 *             &lt;enumeration value="13154352"/>
 *             &lt;enumeration value="13154353"/>
 *             &lt;enumeration value="13154354"/>
 *             &lt;enumeration value="13154355"/>
 *             &lt;enumeration value="13154356"/>
 *             &lt;enumeration value="13154357"/>
 *             &lt;enumeration value="13154358"/>
 *             &lt;enumeration value="13154359"/>
 *             &lt;enumeration value="13154360"/>
 *             &lt;enumeration value="13154361"/>
 *             &lt;enumeration value="13154362"/>
 *             &lt;enumeration value="13154363"/>
 *             &lt;enumeration value="13154364"/>
 *             &lt;enumeration value="13154365"/>
 *             &lt;enumeration value="13154366"/>
 *             &lt;enumeration value="13154367"/>
 *             &lt;enumeration value="13154368"/>
 *             &lt;enumeration value="13154369"/>
 *             &lt;enumeration value="13154370"/>
 *             &lt;enumeration value="13154371"/>
 *             &lt;enumeration value="13154372"/>
 *             &lt;enumeration value="13154373"/>
 *             &lt;enumeration value="13154374"/>
 *             &lt;enumeration value="13154375"/>
 *             &lt;enumeration value="13154376"/>
 *             &lt;enumeration value="13154377"/>
 *             &lt;enumeration value="13154378"/>
 *             &lt;enumeration value="13155064"/>
 *             &lt;enumeration value="13155065"/>
 *             &lt;enumeration value="13155066"/>
 *             &lt;enumeration value="13155067"/>
 *             &lt;enumeration value="13155068"/>
 *             &lt;enumeration value="13155073"/>
 *             &lt;enumeration value="13155075"/>
 *             &lt;enumeration value="13155076"/>
 *             &lt;enumeration value="13155078"/>
 *             &lt;enumeration value="13155079"/>
 *             &lt;enumeration value="13155081"/>
 *             &lt;enumeration value="13155082"/>
 *             &lt;enumeration value="13155084"/>
 *             &lt;enumeration value="13155085"/>
 *             &lt;enumeration value="13155086"/>
 *             &lt;enumeration value="13155087"/>
 *             &lt;enumeration value="13155088"/>
 *             &lt;enumeration value="13155089"/>
 *             &lt;enumeration value="13155090"/>
 *             &lt;enumeration value="13155091"/>
 *             &lt;enumeration value="13155092"/>
 *             &lt;enumeration value="13155093"/>
 *             &lt;enumeration value="13155094"/>
 *             &lt;enumeration value="13155095"/>
 *             &lt;enumeration value="13155096"/>
 *             &lt;enumeration value="13155097"/>
 *             &lt;enumeration value="13155098"/>
 *             &lt;enumeration value="13155099"/>
 *             &lt;enumeration value="13155100"/>
 *             &lt;enumeration value="13155101"/>
 *             &lt;enumeration value="13155102"/>
 *             &lt;enumeration value="13155103"/>
 *             &lt;enumeration value="13155104"/>
 *             &lt;enumeration value="13155105"/>
 *             &lt;enumeration value="13155106"/>
 *             &lt;enumeration value="13155108"/>
 *             &lt;enumeration value="13155109"/>
 *             &lt;enumeration value="13155110"/>
 *             &lt;enumeration value="13155111"/>
 *             &lt;enumeration value="13155288"/>
 *             &lt;enumeration value="13155289"/>
 *             &lt;enumeration value="13155290"/>
 *             &lt;enumeration value="13155291"/>
 *             &lt;enumeration value="13155292"/>
 *             &lt;enumeration value="13155293"/>
 *             &lt;enumeration value="13155294"/>
 *             &lt;enumeration value="13155295"/>
 *             &lt;enumeration value="13155296"/>
 *             &lt;enumeration value="13155297"/>
 *             &lt;enumeration value="13155298"/>
 *             &lt;enumeration value="13155299"/>
 *             &lt;enumeration value="13155300"/>
 *             &lt;enumeration value="13155314"/>
 *             &lt;enumeration value="13155315"/>
 *             &lt;enumeration value="13155316"/>
 *             &lt;enumeration value="13155571"/>
 *             &lt;enumeration value="13157791"/>
 *             &lt;enumeration value="13157876"/>
 *             &lt;enumeration value="13158063"/>
 *             &lt;enumeration value="13158064"/>
 *             &lt;enumeration value="13158065"/>
 *             &lt;enumeration value="13158066"/>
 *             &lt;enumeration value="13158067"/>
 *             &lt;enumeration value="13158068"/>
 *             &lt;enumeration value="13158243"/>
 *             &lt;enumeration value="13158244"/>
 *             &lt;enumeration value="13158245"/>
 *             &lt;enumeration value="13158246"/>
 *             &lt;enumeration value="13158247"/>
 *             &lt;enumeration value="13158248"/>
 *             &lt;enumeration value="13158249"/>
 *             &lt;enumeration value="13158250"/>
 *             &lt;enumeration value="13158251"/>
 *             &lt;enumeration value="13158255"/>
 *             &lt;enumeration value="13158256"/>
 *             &lt;enumeration value="13158317"/>
 *             &lt;enumeration value="13158318"/>
 *             &lt;enumeration value="13158319"/>
 *             &lt;enumeration value="13158320"/>
 *             &lt;enumeration value="13158321"/>
 *             &lt;enumeration value="13158322"/>
 *             &lt;enumeration value="13158323"/>
 *             &lt;enumeration value="13158324"/>
 *             &lt;enumeration value="13158325"/>
 *             &lt;enumeration value="13158326"/>
 *             &lt;enumeration value="13158331"/>
 *             &lt;enumeration value="13158332"/>
 *             &lt;enumeration value="13158352"/>
 *             &lt;enumeration value="13158353"/>
 *             &lt;enumeration value="13158354"/>
 *             &lt;enumeration value="13158363"/>
 *             &lt;enumeration value="13158368"/>
 *             &lt;enumeration value="13158369"/>
 *             &lt;enumeration value="13158370"/>
 *             &lt;enumeration value="13158371"/>
 *             &lt;enumeration value="13158378"/>
 *             &lt;enumeration value="13158381"/>
 *             &lt;enumeration value="13158382"/>
 *             &lt;enumeration value="13158383"/>
 *             &lt;enumeration value="13158384"/>
 *             &lt;enumeration value="13158385"/>
 *             &lt;enumeration value="13158386"/>
 *             &lt;enumeration value="13158387"/>
 *             &lt;enumeration value="13158388"/>
 *             &lt;enumeration value="13158389"/>
 *             &lt;enumeration value="13158463"/>
 *             &lt;enumeration value="13158464"/>
 *             &lt;enumeration value="13158465"/>
 *             &lt;enumeration value="13158466"/>
 *             &lt;enumeration value="13158467"/>
 *             &lt;enumeration value="13158468"/>
 *             &lt;enumeration value="13162436"/>
 *             &lt;enumeration value="13162437"/>
 *             &lt;enumeration value="13162438"/>
 *             &lt;enumeration value="13162440"/>
 *             &lt;enumeration value="13162441"/>
 *             &lt;enumeration value="13162442"/>
 *             &lt;enumeration value="13162443"/>
 *             &lt;enumeration value="13165505"/>
 *             &lt;enumeration value="13165506"/>
 *             &lt;enumeration value="13165507"/>
 *             &lt;enumeration value="13165508"/>
 *             &lt;enumeration value="13165509"/>
 *             &lt;enumeration value="13165510"/>
 *             &lt;enumeration value="13165511"/>
 *             &lt;enumeration value="13165512"/>
 *             &lt;enumeration value="13165513"/>
 *             &lt;enumeration value="13165514"/>
 *             &lt;enumeration value="13165519"/>
 *             &lt;enumeration value="13165520"/>
 *             &lt;enumeration value="13165522"/>
 *             &lt;enumeration value="13165523"/>
 *             &lt;enumeration value="13165524"/>
 *             &lt;enumeration value="13165535"/>
 *             &lt;enumeration value="13165536"/>
 *             &lt;enumeration value="13165550"/>
 *             &lt;enumeration value="13165551"/>
 *             &lt;enumeration value="13165562"/>
 *             &lt;enumeration value="13165563"/>
 *             &lt;enumeration value="13165588"/>
 *             &lt;enumeration value="13165589"/>
 *             &lt;enumeration value="13165590"/>
 *             &lt;enumeration value="13165597"/>
 *             &lt;enumeration value="13165599"/>
 *             &lt;enumeration value="13165644"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="lp_avail" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Y"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="ew_desc">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Each-way bets on 9 places at 1/3 odds"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "occurrence"
})
@XmlRootElement(name = "Market")
public class Market {

    @XmlElement(name = "Occurrence", required = true)
    protected List<Occurrence> occurrence;
    @XmlAttribute(name = "sp_avail", required = true)
    protected String spAvail;
    @XmlAttribute(name = "mkt_typ", required = true)
    protected String mktTyp;
    @XmlAttribute(name = "mkt_id", required = true)
    protected int mktId;
    @XmlAttribute(name = "lp_avail", required = true)
    protected String lpAvail;
    @XmlAttribute(name = "ew_desc")
    protected String ewDesc;

    /**
     * Gets the value of the occurrence property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the occurrence property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOccurrence().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Occurrence }
     * 
     * 
     */
    public List<Occurrence> getOccurrence() {
        if (occurrence == null) {
            occurrence = new ArrayList<Occurrence>();
        }
        return this.occurrence;
    }

    /**
     * Obtiene el valor de la propiedad spAvail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpAvail() {
        return spAvail;
    }

    /**
     * Define el valor de la propiedad spAvail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpAvail(String value) {
        this.spAvail = value;
    }

    /**
     * Obtiene el valor de la propiedad mktTyp.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMktTyp() {
        return mktTyp;
    }

    /**
     * Define el valor de la propiedad mktTyp.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMktTyp(String value) {
        this.mktTyp = value;
    }

    /**
     * Obtiene el valor de la propiedad mktId.
     * 
     */
    public int getMktId() {
        return mktId;
    }

    /**
     * Define el valor de la propiedad mktId.
     * 
     */
    public void setMktId(int value) {
        this.mktId = value;
    }

    /**
     * Obtiene el valor de la propiedad lpAvail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLpAvail() {
        return lpAvail;
    }

    /**
     * Define el valor de la propiedad lpAvail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLpAvail(String value) {
        this.lpAvail = value;
    }

    /**
     * Obtiene el valor de la propiedad ewDesc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEwDesc() {
        return ewDesc;
    }

    /**
     * Define el valor de la propiedad ewDesc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEwDesc(String value) {
        this.ewDesc = value;
    }

}
