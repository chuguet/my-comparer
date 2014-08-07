function JsDateFormatSymbols(e){if(!JsDateFormatSymbols.__symbols__[e])e="en";var t=JsDateFormatSymbols.__symbols__[e];for(p in t)this["_"+p]=t[p]}function JsSimpleDateFormat(e,t){this._arPtn=[];this._ptn=null;this.flexWhiteSpace=false;if(e)this.applyPattern(e);else this.applyPattern(this._getDefaultPattern());if(t){if(t instanceof JsDateFormatSymbols)this.setDateFormatSymbols(t);else this.setDateFormatSymbols(new JsDateFormatSymbols(t))}else{this.setDateFormatSymbols(new JsDateFormatSymbols("en"))}var n=new Date;try{n.setFullYear(n.getFullYear()-80)}catch(r){n=new Date(0)}this.set2DigitYearStart(n)}Function.prototype.__extends__=function(e,t){this.prototype=new e;for(m in t)this.prototype[m]=t[m]};JsDateFormatSymbols.prototype={getAmPmStrings:function(){return this._amPmStrings},getEras:function(){return this._eras},getMonths:function(){return this._months},getShortMonths:function(){return this._shortMonths},getShortWeekdays:function(){return this._shortWeekdays},getWeekdays:function(){return this._weekdays},setAmPmStrings:function(e){this._amPmStrings=e},setEras:function(e){this._eras=e},setMonths:function(e){return this._months=e},setShortMonths:function(e){return this._shortMonths=e},setShortWeekdays:function(e){return this._shortWeekdays=e},setWeekdays:function(e){return this._weekdays=e}};JsDateFormatSymbols.__symbols__={en:{amPmStrings:["AM","PM"],eras:["AD","BC"],months:["January","February","March","April","May","June","July","August","September","October","November","December"],shortMonths:["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"],shortWeekdays:["Sun","Mon","Tue","Wed","Thu","Fri","Sat"],weekdays:["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"]},id:{amPmStrings:["AM","PM"],eras:["M","SM"],months:["Januari","Februari","Maret","April","Mei","Juni","Juli","Agustus","September","Oktober","Nopember","Desember"],shortMonths:["Jan","Feb","Mar","Apr","Mei","Jun","Jul","Agu","Sep","Okt","Nop","Des"],shortWeekdays:["Min","Sen","Sel","Rab","Kam","Jum","Sab"],weekdays:["Minggu","Senin","Selasa","Rabu","Kamis","Jumat","Sabtu"]}};JsSimpleDateFormat._Base=function(){};JsSimpleDateFormat._Base.prototype={isNumber:function(){return false},parse:function(e,t){return-1},toStr:function(){return""}};JsSimpleDateFormat._Str=function(e){JsSimpleDateFormat._Base.call(this);this._vals=[];if(e)this.append(e)};JsSimpleDateFormat._Str.__extends__(JsSimpleDateFormat._Base,{flexWhiteSpace:false,append:function(e){this._vals.push(e)},parse:function(e,t){var n=this.toStr();if(this.flexWhiteSpace){var r=n.replace(/\s+/g," ");if(r==" ")r="\\s+";else r="\\s*"+r.replace(/^\s+/,"").replace(/\s+$/,"").replace(/([^a-zA-Z0-9\s])/g,"\\$1").replace(/\s+/g,"\\s*")+"\\s*";var i=new RegExp("^("+r+")");if(i.test(e))return RegExp.$1.length}else{if(e.indexOf(n)==0)return n.length}return-1},toStr:function(){return this._vals.join("")}});JsSimpleDateFormat._Ltr=function(){JsSimpleDateFormat._Base.call(this);this._count=1;this._parseVal=parseInt("NaN")};JsSimpleDateFormat._Ltr.__extends__(JsSimpleDateFormat._Base,{name:"",dt:new Date,fmtSb:new JsDateFormatSymbols("en"),addCount:function(){this._count++},applyParseValue:function(e,t){return e},getParseValue:function(){return this._parseVal},getValue:function(){return-1}});JsSimpleDateFormat._Text=function(){JsSimpleDateFormat._Ltr.call(this)};JsSimpleDateFormat._Text.__extends__(JsSimpleDateFormat._Ltr,{getIndex:function(){return-1},getLong:function(){var e=this.getIndex(),t=this.getLongValues();if(e>=0&&e<t.length)return t[e];return""},getLongValues:function(){return[]},getShort:function(){var e=this.getIndex(),t=this.getShortValues();if(e>=0&&e<t.length)return t[e];return""},getShortValues:function(){return[]},getValue:function(){return this.getIndex()},parse:function(e,t){this._parseVal=parseInt("NaN");var n=this.getLongValues(),r=this.getShortValues();var i=new RegExp("^("+n.join("|")+"|"+r.join("|")+")","i");if(!i.test(e))return-1;var s=RegExp.$1.toUpperCase();for(var o=0;o<n.length;o++)if(s==n[o].toUpperCase()){this._parseVal=o;return s.length}for(var o=0;o<r.length;o++)if(s==r[o].toUpperCase()){this._parseVal=o;return s.length}},toStr:function(){if(this._count<4)return this.getShort();return this.getLong()}});JsSimpleDateFormat._Number=function(){JsSimpleDateFormat._Ltr.call(this)};JsSimpleDateFormat._Number.__extends__(JsSimpleDateFormat._Ltr,{getNumber:function(){return this.getValue()},isNumber:function(){return true},isValidVal:function(e){return true},parse:function(e,t){this._parseVal="";var n=0,r=e.charAt(0),i="";if(t)while(n<this._count&&r>="0"&&r<="9"){i+=r;if(++n<e.length)r=e.charAt(n);else break}else while(r>="0"&&r<="9"){i+=r;if(++n<e.length)r=e.charAt(n);else break}if(n==0)return-1;var s=parseInt(i,10);if(this.isValidVal(s))this._parseVal=s;else return-1;return n},toStr:function(){var e=this.getNumber()+"",t="";if(e.charAt(0)=="-"){e=e.substr(1);t="-"}while(e.length<this._count)e="0"+e;return t+e}});JsSimpleDateFormat._Month=function(){JsSimpleDateFormat._Text.call(this)};JsSimpleDateFormat._Month.__extends__(JsSimpleDateFormat._Text,{name:"month",isNumber:function(){if(this._count<3)return true;else return false},isValidVal:function(e){return e>=1&&e<=12},parse:function(e,t){if(this._count<3)return JsSimpleDateFormat._Number.prototype.parse.call(this,e,t);return JsSimpleDateFormat._Text.prototype.parse.call(this,e,t)},toStr:function(){if(this._count<3)return JsSimpleDateFormat._Number.prototype.toStr.call(this);return JsSimpleDateFormat._Text.prototype.toStr.call(this)}});JsSimpleDateFormat._Year=function(){JsSimpleDateFormat._Number.call(this)};JsSimpleDateFormat._Year.__extends__(JsSimpleDateFormat._Number,{name:"year",stC:1900,stY:1970,parse:function(e,t){var n=0;if(e.charAt(0)=="-"){e=e.substr(1);n++}var r=JsSimpleDateFormat._Number.prototype.parse.call(this,e,t);if(r==-1)return-1;if(n>0)this._parseVal=-this._parseVal;if(this._count<3&&this._parseVal>0&&r==2){var i=this.stC+this._parseVal;if(i<=this.stY)i+=100;this._parseVal=i}return r+n},toStr:function(){if(this._count<4){var e=this.getNumber()%100+"";if(e.length<2)return"0"+e;return e}return JsSimpleDateFormat._Number.prototype.toStr.call(this)}});JsSimpleDateFormat._ltr={};JsSimpleDateFormat._ltr.G=function(){JsSimpleDateFormat._Text.call(this)};JsSimpleDateFormat._ltr.G.__extends__(JsSimpleDateFormat._Text,{name:"era",getIndex:function(){return this.dt.getFullYear()>0?0:1},getLongValues:function(){return this.fmtSb.getEras()},getShortValues:function(){return this.getLongValues()}});JsSimpleDateFormat._ltr.y=function(){JsSimpleDateFormat._Year.call(this)};JsSimpleDateFormat._ltr.y.__extends__(JsSimpleDateFormat._Year,{applyParseValue:function(e,t){if(t.era){if(t.era.getParseValue()==0&&this._parseVal<=0)return null;if(t.era.getParseValue()==1&&this._parseVal>0)this._parseVal=-this._parseVal+1}e.setFullYear(this._parseVal);return e},getNumber:function(){var e=this.getValue();return e<=0?-e+1:e},getValue:function(){return this.dt.getFullYear()}});JsSimpleDateFormat._ltr.M=function(){JsSimpleDateFormat._Month.call(this)};JsSimpleDateFormat._ltr.M.__extends__(JsSimpleDateFormat._Month,{applyParseValue:function(e,t){var n=this.getParseValue(),r=e.getDate();e.setMonth(n);while(e.getMonth()!=n){e.setDate(--r);e.setMonth(n)}return e},getIndex:function(){return this.dt.getMonth()},getLongValues:function(){return this.fmtSb.getMonths()},getNumber:function(){return this.dt.getMonth()+1},getParseValue:function(){return this._count<3?this._parseVal-1:this._parseVal},getShortValues:function(){return this.fmtSb.getShortMonths()}});JsSimpleDateFormat._ltr.D=function(){JsSimpleDateFormat._Number.call(this)};JsSimpleDateFormat._ltr.D.__extends__(JsSimpleDateFormat._Number,{_ends:[31,28,31,30,31,30,31,31,30,31,30,31],name:"dayOfYear",_checkLeapYear:function(e){var t=new Date(e.getTime());t.setDate(1);t.setMonth(1);t.setDate(29);if(t.getDate()==29)this._ends[1]=29;else this._ends[1]=28},applyParseValue:function(e,t){if(t.year)if(t.year.applyParseValue(e,t)==null)return null;this._checkLeapYear(e);var n=this._ends,r=this.getParseValue(),i=0;while(r>n[i]&&i<n.length)r-=n[i++];if(i>=n.length)return null;e.setDate(1);e.setMonth(i);e.setDate(r);return e},getDay:function(){this._checkLeapYear(this.dt);var e=this._ends;var t=this.dt.getMonth(),n=0;for(var r=0;r<t;r++)n+=e[r];return n+this.dt.getDate()},getValue:function(){return this.getDay()},isValidVal:function(e){return e>=1&&e<=366}});JsSimpleDateFormat._ltr.d=function(){JsSimpleDateFormat._ltr.D.call(this)};JsSimpleDateFormat._ltr.d.__extends__(JsSimpleDateFormat._ltr.D,{name:"day",applyParseValue:function(e,t){if(t.year)if(t.year.applyParseValue(e,t)==null)return null;this._checkLeapYear(e);if(t.month)if(t.month.applyParseValue(e,t)==null)return null;var n=this._ends,r=this.getParseValue(),i=e.getMonth();if(r<1||r>n[i])return null;e.setDate(r);return e},getDay:function(){return this.dt.getDate()},isValidVal:function(e){return e>=1&&e<=31}});JsSimpleDateFormat._ltr.w=function(){JsSimpleDateFormat._ltr.D.call(this)};JsSimpleDateFormat._ltr.w.__extends__(JsSimpleDateFormat._ltr.D,{name:"weekOfYear",_resetMonth:function(e){e.setMonth(0)},applyParseValue:function(e,t){e.setDate(1);this._resetMonth(e);e.setTime(e.getTime()-e.getDay()*864e5+(this._parseVal-1)*7*864e5);return e},getParseValue:function(){return this.getValue()},getValue:function(){return this.getWeek()},getWeek:function(){var e=this.getDay();var t=Math.ceil(e/7);e=e%7;e=(e?e:7)-1;return this.dt.getDay()<e?t+1:t},isValidVal:function(e){return e>=1&&e<=54}});JsSimpleDateFormat._ltr.W=function(){JsSimpleDateFormat._ltr.w.call(this)};JsSimpleDateFormat._ltr.W.__extends__(JsSimpleDateFormat._ltr.w,{name:"weekOfMonth",_resetMonth:function(e){},getDay:function(){return this.dt.getDate()},isValidVal:function(e){return e>=1&&e<=6}});JsSimpleDateFormat._ltr.F=function(){JsSimpleDateFormat._Number.call(this)};JsSimpleDateFormat._ltr.F.__extends__(JsSimpleDateFormat._Number,{name:"dayOfWeekInMonth",applyParseValue:function(e,t){e.setDate((this.getParseValue()-1)*7+1);return e},isValidVal:function(e){return e>=1&&e<=5},getValue:function(){return Math.ceil(this.dt.getDate()/7)}});JsSimpleDateFormat._ltr.E=function(){JsSimpleDateFormat._Text.call(this)};JsSimpleDateFormat._ltr.E.__extends__(JsSimpleDateFormat._Text,{name:"dayOfWeek",applyParseValue:function(e,t){e.setDate(1);var n=e.getDay();var r=this._parseVal<n?this._parseVal+7:this._parseVal;e.setTime(e.getTime()+(r-n)*864e5);return e},getIndex:function(){return this.dt.getDay()},getLongValues:function(){return this.fmtSb.getWeekdays()},getShortValues:function(){return this.fmtSb.getShortWeekdays()}});JsSimpleDateFormat._ltr.a=function(){JsSimpleDateFormat._Text.call(this)};JsSimpleDateFormat._ltr.a.__extends__(JsSimpleDateFormat._Text,{name:"ampm",getIndex:function(){return this.dt.getHours()<12?0:1},getLongValues:function(){return this.fmtSb.getAmPmStrings()},getShortValues:function(){return this.getLongValues()}});JsSimpleDateFormat._ltr.H=function(){JsSimpleDateFormat._Number.call(this)};JsSimpleDateFormat._ltr.H.__extends__(JsSimpleDateFormat._Number,{name:"hour",applyParseValue:function(e,t){e.setHours(this.getParseValue());return e},getValue:function(){return this.dt.getHours()},isValidVal:function(e){return e>=0&&e<=23}});JsSimpleDateFormat._ltr.k=function(){JsSimpleDateFormat._ltr.H.call(this)};JsSimpleDateFormat._ltr.k.__extends__(JsSimpleDateFormat._ltr.H,{getParseValue:function(){return this._parseVal==24?0:this._parseVal},getNumber:function(){var e=this.dt.getHours();return e>0?e:24},isValidVal:function(e){return e>=1&&e<=24}});JsSimpleDateFormat._ltr.K=function(){JsSimpleDateFormat._Number.call(this)};JsSimpleDateFormat._ltr.K.__extends__(JsSimpleDateFormat._Number,{name:"h12",applyParseValue:function(e,t){var n=this.getParseValue();if(t.ampm&&t.ampm.getParseValue()==1)n+=12;e.setHours(n);return e},getValue:function(){return this.dt.getHours()%12},isValidVal:function(e){return e>=0&&e<=11}});JsSimpleDateFormat._ltr.h=function(){JsSimpleDateFormat._ltr.K.call(this)};JsSimpleDateFormat._ltr.h.__extends__(JsSimpleDateFormat._ltr.K,{getParseValue:function(){return this._parseVal==12?0:this._parseVal},getNumber:function(){var e=this.dt.getHours()%12;return e>0?e:12},isValidVal:function(e){return e>=1&&e<=12}});JsSimpleDateFormat._ltr.m=function(){JsSimpleDateFormat._Number.call(this)};JsSimpleDateFormat._ltr.m.__extends__(JsSimpleDateFormat._Number,{name:"minute",applyParseValue:function(e,t){e.setMinutes(this.getParseValue());return e},getValue:function(){return this.dt.getMinutes()},isValidVal:function(e){return e>=0&&e<=59}});JsSimpleDateFormat._ltr.s=function(){JsSimpleDateFormat._Number.call(this)};JsSimpleDateFormat._ltr.s.__extends__(JsSimpleDateFormat._Number,{name:"second",applyParseValue:function(e,t){e.setSeconds(this.getParseValue());return e},getValue:function(){return this.dt.getSeconds()},isValidVal:function(e){return e>=0&&e<=59}});JsSimpleDateFormat._ltr.S=function(){JsSimpleDateFormat._Number.call(this)};JsSimpleDateFormat._ltr.S.__extends__(JsSimpleDateFormat._Number,{name:"ms",applyParseValue:function(e,t){e.setMilliseconds(this.getParseValue());return e},getValue:function(){return this.dt.getMilliseconds()},isValidVal:function(e){return e>=0&&e<=999}});JsSimpleDateFormat.prototype={_getDefaultPattern:function(){return"dd MMMM yyyy hh:mm a"},_getInitDate:function(){var e=new Date(0);e.setTime(e.getTime()+e.getTimezoneOffset()*6e4);return e},applyPattern:function(e){this._arPtn=[];var t=JsSimpleDateFormat._ltr;var n=new JsSimpleDateFormat._Str(""),r="",i=null,s,o=false,u=-1;while(++u<e.length){var a=e.charAt(u);if(a=="'"){if(u<e.length-1&&e.charAt(u+1)=="'"){n.append("'");u++}else{o=!o}r=""}else if(o){n.append(a)}else if(a==r){i.addCount()}else if(s=t[a]){i=new s;if(n.toStr()!="")this._arPtn.push(n);n=new JsSimpleDateFormat._Str("");this._arPtn.push(i);r=a}else{n.append(a);r=""}}if(n.toStr()!="")this._arPtn.push(n);this._ptn=e},format:function(e){JsSimpleDateFormat._Ltr.prototype.fmtSb=this._fmtSb;JsSimpleDateFormat._Ltr.prototype.dt=e;var t="",n=this._arPtn;for(var r=0;r<n.length;r++)t+=n[r].toStr();return t},get2DigitYearStart:function(){return this._stDt},getDateFormatSymbols:function(){return this._fmtSb},parse:function(e,t){JsSimpleDateFormat._Ltr.prototype.fmtSb=this._fmtSb;JsSimpleDateFormat._Str.prototype.flexWhiteSpace=this.flexWhiteSpace;JsSimpleDateFormat._Year.prototype.stY=this._stY;JsSimpleDateFormat._Year.prototype.stC=this._stC;if(!t)t={index:0,errorIndex:-1};var n=t.index,r=0,i=this._arPtn,s={};while(r<i.length){var o=i[r++];var u=r<i.length?i[r].isNumber():false;var a=o.parse(e.substr(n),u);if(a==-1){t.errorIndex=n;return null}if(o instanceof JsSimpleDateFormat._Ltr){var f=o.name;if(s[f]){if(s[f].getParseValue()!=o.getParseValue()){t.errorIndex=n;return null}}else{s[f]=o}}n+=a}var l=this._getInitDate();var c=["year","month","dayOfWeek","dayOfWeekInMonth","weekOfMonth","weekOfYear","dayOfYear","day","hour","h12","minute","second","ms"];for(r=0;r<c.length;r++){var f=c[r];if(s[f])if(s[f].applyParseValue(l,s)==null){t.errorIndex=t.index+n;return null}}JsSimpleDateFormat._Ltr.prototype.dt=l;for(var f in s)if(s[f].getParseValue()!=s[f].getValue()){t.errorIndex=t.index+n;return null}t.index+=n;return l},set2DigitYearStart:function(e){this._stDt=e;var t=Math.abs(e.getFullYear());this._stY=t;this._stC=t-t%100},setDateFormatSymbols:function(e){this._fmtSb=e},toPattern:function(){return this._ptn}}