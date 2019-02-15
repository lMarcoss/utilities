package com.utils.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Marcos Santiago Leonardo
 * Description: clase estática para validar, convertir y sumar fechas
 * Date: 1/30/19
 */
public final class ValidateDate {
    private static final String SEPARATOR_DAY = "/";

    private ValidateDate() {
    }

    /**
     * @param fecha
     * @return valida si la fecha es correcta
     */
    public static boolean isValidDate(String fecha) {
        if (fecha != null && !fecha.equalsIgnoreCase("") && !fecha.equalsIgnoreCase("null")) {

            try {
                convertToDate(fecha);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * @param fecha
     * @return convierte una fecha dd/MM/yyyy a fecha Date
     * @throws Exception
     */
    public static Date convertToDate(String fecha) throws Exception {
        SimpleDateFormat sdfrmt = new SimpleDateFormat("dd/MM/yyyy");
        sdfrmt.setLenient(false);
        try {
            return sdfrmt.parse(fecha);
        } catch (ParseException e) {
            throw new Exception(e);
        }
    }

    /**
     * @param fecha
     * @param daysSum
     * @return suma días a una fecha
     */
    public static Date getNextDayBySum(Date fecha, int daysSum) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        c.add(Calendar.DATE, daysSum);
        return (Date) c.getTime().clone();
    }

    /**
     * @param fecha
     * @return convierte una fecha DAte a string dd/MM/yyyy
     */
    public static String convertDateToString(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return formato.format(fecha);
    }


    /**
     * @param monthsBeforeTheCurrent
     * @return fecha inicial y final del mes (MES_ACTUAL - monthsBeforeTheCurrent) = MES_CALCULADO
     */
    public static String[] createStartAndEndDayOfMonth(int monthsBeforeTheCurrent) {
        // substract days
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, monthsBeforeTheCurrent);
        Date result = cal.getTime();

        cal.setTime(result);

        // first day of month
        int day = 1;
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);

        //last day of month
        int endDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

        String start = day + SEPARATOR_DAY + month + SEPARATOR_DAY + year;
        String end = endDayOfMonth + SEPARATOR_DAY + month + SEPARATOR_DAY + year;

        return new String[]{start, end};
    }

    public static String convertToDateEmision(String fecha, String separator) {
        String[] date = fecha.split(SEPARATOR_DAY);
        return date[2] + separator + date[1] + separator + date[0];
    }
}
