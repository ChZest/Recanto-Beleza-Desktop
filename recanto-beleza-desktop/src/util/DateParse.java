package util;

/* @author Lucas Corrêa */
public class DateParse {
    
	public static java.util.Date parseDate(String date) throws java.text.ParseException {
		if (date.indexOf('-')>=0)
			date = date.replace('-', '/');
		
		String dateFormat = "dd/MM/yyyy";
		if ((date.length()>=3) && (date.charAt(2)!='/'))
			dateFormat = "yyyy/MM/dd";
		
		String formatPatern = dateFormat;
		if (date.length()==13) formatPatern = dateFormat+" HH";
		if (date.length()==16) formatPatern = dateFormat+" HH:mm";
		if (date.length()>=19) formatPatern = dateFormat+" HH:mm:ss";
		
		return DateParse.parseDate(date, formatPatern);
	}
	
	public static java.util.Date parseDate(String date, String Pattern) throws java.text.ParseException {
		java.text.SimpleDateFormat sp = new java.text.SimpleDateFormat(Pattern);
		sp.setLenient(false);
		java.util.Date data = sp.parse(date);
		return data;
	}
	
	public static java.util.Date parseDate(String date, String Pattern, java.util.Locale loc)
                throws java.text.ParseException {
		java.text.SimpleDateFormat sp = new java.text.SimpleDateFormat(Pattern, loc);
		sp.setLenient(false);
		return sp.parse(date);
	}

	
	/**
	 * MÃ©todo que retorna uma data truncada recebendo como parametro outra data
	 * @param date
	 * @return Date data truncada;
	 */
	public static java.util.Date truncDate(java.util.Date date){
		if (date==null)
			return null;
		
		java.util.Calendar cIn = new java.util.GregorianCalendar();
		cIn.setTime(date);
		int ano = cIn.get(java.util.Calendar.YEAR);
		int mes = cIn.get(java.util.Calendar.MONTH);
		int dia = cIn.get(java.util.Calendar.DAY_OF_MONTH);
		
		java.util.Calendar cOut = new java.util.GregorianCalendar();
		cOut.set(ano, mes, dia, 0, 0, 0);
		cOut.set(java.util.Calendar.MILLISECOND, 0);
		
		return cOut.getTime();
	}
	
	/**
	 * Retorna o Timestamp de uma data.
	 * @param date
	 * @return Timestamp;
	 */
	public static java.sql.Timestamp dateToTimestamp(java.util.Date date){
		if (date==null)
			return null;
		else 
			return	new java.sql.Timestamp(date.getTime());
	}
	
	/**
	 * MÃ©todo que retorna uma String que represente o parametro de data.
	 * O formato desta String Ã© "dd/MM/yyyy".
	 * @param date
	 * @return String representando a data no formato 'dd/MM/yyyy';
	 */
	public static String dateToString(java.util.Date date){
		return DateParse.dateToString(date, "dd/MM/yyyy");
	}
	
	/**
	 * MÃ©todo que retorna uma String que represente o parametro de data.
	 * O formato desta String Ã© definido pelo parametro Pattern.
	 * @param date
     * @param Pattern
	 * @return String
	 */
	public static String dateToString(java.util.Date date, String Pattern){
		java.text.SimpleDateFormat sFormat = new java.text.SimpleDateFormat (Pattern);
		return sFormat.format(date);
	}	
	
	/**
	 * @param  dataReferencia
	 * @return String
	 * */
	public static String somaDia(String dataReferencia){
		int iDia = Integer.parseInt(dataReferencia.substring(0, 2));
		int iMes = Integer.parseInt(dataReferencia.substring(3, 5));
		int iAno = Integer.parseInt(dataReferencia.substring(6, 10));
		java.util.Calendar c = new java.util.GregorianCalendar(iAno, iMes-1, iDia);
		c.add(java.util.Calendar.DATE, 1);
		java.text.SimpleDateFormat sFormat = new java.text.SimpleDateFormat ("dd/MM/yyyy");
		dataReferencia = sFormat.format(c.getTime());
		return dataReferencia;
	}
	
	public static java.util.Date somaDias(java.util.Date date, int dias){
		return soma(date, 0, 0, dias);
	}

	public static java.util.Date somaMeses(java.util.Date date, int meses){
		return soma(date, 0, meses, 0);
	}

	public static java.util.Date somaAnos(java.util.Date date, int anos){
		return soma(date, anos, 0, 0);
	}
	
	public static java.util.Date soma(java.util.Date date, int anos, int meses, int dias){
		java.util.Calendar c = new java.util.GregorianCalendar();
		c.setTime(date);
		c.add(java.util.Calendar.DATE, dias);
		c.add(java.util.Calendar.MONTH, meses);
		c.add(java.util.Calendar.YEAR, anos);

		return c.getTime();
	}
	
	public static long getMiliSecFromMinute(long minute){
		long ret = (1000*60*minute);
		return ret;
	}
	
	public static long getMiliSecFromHour(long hour){
		long ret = (1000*60*60*hour);
		return ret;
	}
	

	/**
	 * MÃ©todo usado para recuperar a data inicial do ciclo atual.<br>
	 * ex: dia atual (21/10/2009 15:00:00) + dia ciclo (13) = 13/10/2009 00:00:00
	 * 
	 * @param diaCiclo dia de corte no ciclo do cliente
	 * @return Date - data inicial do ciclo
	 * */
	public static java.util.Date getDtInicioCiclo(int diaCiclo){
		java.util.GregorianCalendar calendar =  new java.util.GregorianCalendar();
		calendar.set(java.util.Calendar.DAY_OF_MONTH, diaCiclo);
		calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);
		calendar.set(java.util.Calendar.MINUTE, 0);
		calendar.set(java.util.Calendar.SECOND, 0);
		
		java.util.Date d = calendar.getTime();
		java.util.Date dAtual = new java.util.Date();
		
		if (dAtual.compareTo(d)<0)
			d = DateParse.somaMeses(d, -1);
		
		return d;
	}
	
	/**
	 * Metodo que recebe uma data como entrada e retorna um array de inteiros
	 * de 3 posiÃ§Ãµes, que sÃ£o dia, mes e ano respectivamente.
     * @param d
	 * @return int[]
	 */
	public static int getDia(java.util.Date d){
		int ret;
		
		java.util.Calendar c = new java.util.GregorianCalendar();
		c.setTime(d);
		
		ret = c.get(java.util.Calendar.DAY_OF_MONTH);
		
		return ret;
	}
	
	/**
	 * Metodo que recebe uma data como entrada e retorna um array de inteiros
	 * de 3 posiÃ§Ãµes, que sÃ£o dia, mes e ano respectivamente.
	 * @param d
	 * @return int[]
	 */
	public static int[] dateToDMAintArr(java.util.Date d){
		int [] retArr = new int[3];
		
		java.util.Calendar c = new java.util.GregorianCalendar();
		c.setTime(d);
		
		retArr[0] = c.get(java.util.Calendar.DAY_OF_MONTH);
		retArr[1] = c.get(java.util.Calendar.MONTH)+1;
		retArr[2] = c.get(java.util.Calendar.YEAR);
		
		return retArr;
	}
	
	/**
	 * Verificar se duas datas se encontram no mesmo dia/mes/ano
	 * nÃ£o levando em conta as horas/minutos/segundos.
	 *
     * @param date1
     * @param date2
     * @return  */
	public static boolean equalsDate(java.util.Date date1, java.util.Date date2){
		boolean ret;
		
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		
        //Divide-se pela quantidade de milisegundos de um dia
		//e obtem-se a quantidade de dias decorridos apartir 
		//do dia 01/01/1970 00:00:00:000 atÃ© a data em questao. 
		long dia1 = time1/(1000*60*60*24);
		long dia2 = time2/(1000*60*60*24);
		
                ret = dia1==dia2;
		
		return ret;
	}
        
        public static boolean biggerDate(java.util.Date date1, java.util.Date date2){
		boolean ret = true;
		
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		
        //Divide-se pela quantidade de milisegundos de um dia
		//e obtem-se a quantidade de dias decorridos apartir 
		//do dia 01/01/1970 00:00:00:000 atÃ© a data em questao. 
		long dia1 = time1/(1000*60*60*24);
		long dia2 = time2/(1000*60*60*24);
		
		return (dia1 < dia2);
	}
	
	public static void main(String [] args) throws java.text.ParseException{
		System.out.println("====================================");
		System.out.println("dd/MM/yyyy");
		System.out.println();
		String dateStr = "28/03/2010";
		java.util.Date date = DateParse.parseDate(dateStr, "dd/MM/yyyy");
		System.out.println(dateStr+ " = " +date);
		
		int[] dma = DateParse.dateToDMAintArr(date);
		java.util.Date ini = DateParse.somaDias(date, -(dma[0]-1) );
		ini = DateParse.somaMeses(ini, -(dma[1]-1) );
		System.out.println(ini);
		
		java.util.Date fim = DateParse.somaAnos(ini, 1);
		System.out.println(fim);
		
		
                
	}
	
	/*
	public static void main(String [] args) throws ParseException{
		System.out.println("====================================");
		System.out.println("dd/MM/yyyy");
		System.out.println();
		String date = "21/02/2010";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "21/02/2010 13";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "21/02/2010 13:45";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "21/02/2010 13:45:17";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "21/02/2010 13:45:17.2";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		
		System.out.println("====================================");
		System.out.println("yyyy/MM/dd");
		System.out.println();
		date = "2010/02/21";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "2010/02/21 13";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "2010/02/21 13:45";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "2010/02/21 13:45:17";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "2010/02/21 13:45:17.2";
		System.out.println(date+ " = " +DateParse.parseDate(date));

		System.out.println("====================================");
		System.out.println("dd-MM-yyyy");
		System.out.println();
		date = "21-02-2010";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "21-02-2010 13";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "21-02-2010 13:45";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "21-02-2010 13:45:17";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "21-02-2010 13:45:17.2";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		
		System.out.println("====================================");
		System.out.println("yyyy-MM-dd");
		System.out.println();
		date = "2010-02-21";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "2010-02-21 13";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "2010-02-21 13:45";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "2010-02-21 13:45:17";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		date = "2010-02-21 13:45:17.2";
		System.out.println(date+ " = " +DateParse.parseDate(date));
		
		
		System.out.println("====================================");
		System.out.println("truncDate(date);");
		Date dateIn = new Date();
		Date dateTrunc = DateParse.truncDate(dateIn);
		System.out.println("dateIn = " +dateIn);
		System.out.println("dateTrunc = " +dateTrunc);
		System.out.println("Timestamp = " +DateParse.dateToTimestamp(dateTrunc));
		System.out.println("====================================");
		date = "2011-12-31 23:59:59";
		dateIn = DateParse.parseDate(date);
		dateTrunc = DateParse.truncDate(dateIn);
		System.out.println("dateIn = " +dateIn);
		System.out.println("dateTrunc = " +dateTrunc);
		System.out.println("Timestamp = " +DateParse.dateToTimestamp(dateTrunc));

		System.out.println("====================================");
		dateIn = null;
		dateTrunc = DateParse.truncDate(dateIn);
		System.out.println("dateIn = " +dateIn);
		System.out.println("dateTrunc = " +dateTrunc);
		System.out.println("Timestamp = " +DateParse.dateToTimestamp(dateTrunc));
		System.out.println("====================================");
	}
        */ 
}
