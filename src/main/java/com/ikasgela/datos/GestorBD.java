package com.ikasgela.datos;

import com.ikasgela.Main;

import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestorBD {
    private static final List<Moneda> monedas_Result = new ArrayList<>();
    private static final List<Cotizacion> cotizaciones_Result = new ArrayList<>();

    public static List<Moneda> leerDatos() {
        String cad_Conexion = "jdbc:sqlite:criptomonedas.db";
        try {
            Connection conexion = DriverManager.getConnection(cad_Conexion);

            //Consulta Monedas
            Statement monedas_St = conexion.createStatement();
            ResultSet monedas_rs = monedas_St.executeQuery("SELECT * FROM monedas");

            while (monedas_rs.next()) {
                Moneda moneda_actual = new Moneda(monedas_rs.getLong("id"),
                        monedas_rs.getString("codigo"), monedas_rs.getString("nombre"));

                //Consulta Cotizaciones
                PreparedStatement cotizaciones_St = conexion.prepareStatement("SELECT * FROM cotizaciones WHERE moneda_id = ?");
                cotizaciones_St.setLong(1, moneda_actual.getId());
                ResultSet cotizaciones_rs = cotizaciones_St.executeQuery();

                while (cotizaciones_rs.next()) {
                    LocalDate fecha = LocalDate.parse(cotizaciones_rs.getString("fecha"));
                    Cotizacion cotizacion_actual = new Cotizacion(cotizaciones_rs.getLong("id"),
                            fecha,
                            cotizaciones_rs.getDouble("valor"), moneda_actual);
                    moneda_actual.AddCotizaciones(cotizacion_actual);
                    cotizaciones_Result.add(cotizacion_actual);
                }
                monedas_Result.add(moneda_actual);
            }
            Main.setCotizaciones(cotizaciones_Result);
            Main.setMonedas(monedas_Result);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
