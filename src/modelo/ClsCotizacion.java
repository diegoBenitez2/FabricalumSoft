/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


/**
 *
 * @author DiegoB
 */
public class ClsCotizacion {
    //Se declara una variable de tipo ClsConexion para establecer la conexion
    private controlador.ClsConexion conncot= new controlador.ClsConexion();
   
   //Se declara una variable de tipo PrepraredStatement para realizar la consulta a la bd
    public PreparedStatement sqlcot;
    
    //Se declara una variable de tipo ResultSet para capturar los datos de una consulta en bd.
    public ResultSet datoscot;

//Metodo para consultar los productos que esten en una cotizacion en la tabla tbcotizacion_producto en bd. 
public void MtdBuscarProductoCotizacion( int cod_cot_cp){
    try {
        conncot.conectar();
        sqlcot = conncot.confa.prepareStatement("Select cod_pro, anc_pro, alt_pro from tbproducto as p inner join tbcotizacion_producto as cp on cod_pro_cp = cod_pro where cod_cot_cp = ?");
        sqlcot.setInt(1, cod_cot_cp);
        sqlcot.executeQuery();
        datoscot = sqlcot.getResultSet();
        conncot.cerrar();
    } catch (Exception e) {
                System.out.println("Error al buscar producto en cotizacion en clase cotizacion: "+e.getLocalizedMessage());

    }
}

//Se trae los insumos que esten añadidos a un producto en la tabla tbmateriales_producto en bd.
public void listarTablaInsumoCotizacion(int cod){
    try{
    conncot.conectar();
    sqlcot=conncot.confa.prepareStatement("select cod_mat, nom_mat,tip_mat,uso_mat,ref_mat,col_mat,fab_mat,can_mat,pre_mat from tbmateriales as mat inner join tbmateriales_producto as mp on mp.cod_mat_mp =mat.cod_mat where cod_pro_mp =?");
    sqlcot.setInt(1, cod);
    sqlcot.executeQuery();
    datoscot=sqlcot.getResultSet();
    conncot.cerrar();
    
    }
    catch(Exception ex){
     System.out.println("Error al llenar tabla insumos cotizacion en clase cotizacion"+ ex.getLocalizedMessage());
    }
}

//Metodo para consultar el codigo del insumo segun referencia(tipo) en la tabla tbmateriales en bd
public void MtdBuscarTablaInsumoCotizacion( String ref, String color){
    try{
    conncot.conectar();
    sqlcot=conncot.confa.prepareStatement("select cod_mat from tbmateriales  where (ref_mat = ? and col_mat = ?)or (ref_mat = ?) ");
    sqlcot.setString(1, ref);
    sqlcot.setString(2, color);
    sqlcot.setString(3, ref);


    sqlcot.executeQuery();
    datoscot=sqlcot.getResultSet();
    conncot.cerrar();
    
    }
    catch(Exception ex){
     System.out.println("Error al llenar tabla insumos cotizacion en clase cotizacion"+ ex.getLocalizedMessage());
    }
}

//Metodo para insertar el codigo del insumo y codigo producto en la tabla tb_materiales_producto en bd.
public void MtdInsertarInsumoCotizacion(int cod_pro, int cod_mat){

    try {
        conncot.conectar();
        sqlcot = conncot.confa.prepareStatement("insert into tbmateriales_producto  values(?,?)");
        sqlcot.setInt(1,cod_mat);
        sqlcot.setInt(2,cod_pro);
        sqlcot.executeUpdate();
        conncot.cerrar();
    } catch (Exception e) {
        System.out.println("Error al insertar insumo en clase cotizacion: "+e.getLocalizedMessage());
    }
}

//Metodo para consultar toda la tabla tbmateriales en bd.
public void listarTablaInsumo(){
    try{
    conncot.conectar();
    sqlcot=conncot.confa.prepareStatement("select cod_mat,nom_mat,tip_mat,uso_mat,ref_mat,col_mat,fab_mat,can_mat,pre_mat,cod_dpc_mat from tbmateriales");
    sqlcot.executeQuery();
    datoscot=sqlcot.getResultSet();
    conncot.cerrar();
    
    }
    catch(Exception ex){
     System.out.println("Error al llenar tabla insumos en clase cotizacion"+ ex.getLocalizedMessage());
    }
}

//Metodo para eliminar los regidtros de la tabla tbmateriales_producto por campo de codigo del insumo y codigo de producto en bd.
public void EliminarInsumoProducto(int cod_pro, int cod_mat){
    try{
    conncot.cerrar();
    sqlcot = conncot.confa.prepareStatement("delete from tbmateriales_producto where cod_mat_mp=? and cod_pro_mp=?");
    sqlcot.setInt(1, cod_mat);
    sqlcot.setInt(2, cod_pro);

    sqlcot.executeUpdate();
    datoscot = sqlcot.getResultSet();
    conncot.cerrar();
}
    catch(Exception ex){
        JOptionPane.showMessageDialog(null, "No se puede eliminar el registro:"+ex.getLocalizedMessage(),"Cotizacion",JOptionPane.WARNING_MESSAGE);
        System.out.println("Error al eleminar insumo en clase cotizacion"+ ex.getLocalizedMessage());
    }
}

//Metodo para insertar codigo de producto y insumo en tabla tbmateriales_produucto en bd.
public void AgregarInsumoCotizacion(int cod_pro, int cod_mat){
    conncot.conectar();
    try {
        sqlcot = conncot.confa.prepareStatement("insert into tbmateriales_producto  (cod_mat_mp, cod_pro_mp) values(?,?)");
        sqlcot.setInt(1,cod_mat);
        sqlcot.setInt(2,cod_pro);
        sqlcot.executeUpdate();
        conncot.cerrar();
    } catch (Exception e) {
        System.out.println("Error al agregar insumo en clase cotizacion: "+ e.getLocalizedMessage());

    }

}

//Metodo para consultar los insumos que esten añadidos a un producto en bd.
public void MtdTraerInsumosCotizacion(int cod_pro){
    try {
        conncot.conectar();
        sqlcot = conncot.confa.prepareStatement("select nom_mat,can_mat,pre_mat,cod_dpc_mat from tbmateriales as m inner join tbmateriales_producto as mp on mp.cod_mat_mp=m.cod_mat where mp.cod_pro_mp =?");
        sqlcot.setInt(1, cod_pro);
        sqlcot.executeQuery();
        datoscot = sqlcot.getResultSet();
        conncot.cerrar();
    } catch (Exception e) {
        System.out.println("Error al traer insumos cotizacion"+e.getLocalizedMessage());
    }

}

//Metodo para consultar los despieces añadidos a un producto en  bd.
public void MtdDespiecesCotizacion(int cod_pro){
conncot.conectar();
    try {
        sqlcot = conncot.confa.prepareStatement("select cod_dpc,des_dpc,sis_dpc,ref_dpc,for_dpc,can_dpc,cod_dpc_mat from tbdespiece as d,tbproducto as p inner join tbtipoproducto as tp on p.cod_tip_pto_pro =tp.cod_tip_pto where d.sis_dpc=tp.sis_tip_pto and d.ref_dpc=tp.ref_tip_pto and p.cod_pro = ?");
        sqlcot.setInt( 1,cod_pro);
        sqlcot.executeQuery();
        datoscot = sqlcot.getResultSet();
        conncot.cerrar();
    } catch (Exception e) {
        System.out.println("Error al Traer despieces en clase cotizacion: "+e.getLocalizedMessage());
    }

}

//Metodo para insertar despieces a un producto en la tabla tbdespiece_producto en bd.
public void MtdAgregarDespieceProducto(int cod_dpc, int cod_pro,String med_dpc,String can_dpc){
conncot.conectar();
    try {
        sqlcot = conncot.confa.prepareStatement("insert into tbdespiece_producto values(?,?,?,?)");
        sqlcot.setInt(1, cod_pro);
        sqlcot.setInt(2, cod_dpc);
        sqlcot.setString(3, med_dpc);
        sqlcot.setString(4, can_dpc);
        sqlcot.executeUpdate();
        conncot.cerrar();
    } catch (Exception e) {
        System.out.println("Error al insertar despiece y producto en clase cotizacion: "+e.getLocalizedMessage());
    }


}

//Metodo para insertar la cotizacion en la tabla tbcotizacion en bd.
public void MtdInsertarCotizacion(String des_cot,String fec_cot, String id_cli){
conncot.conectar();
    try {
        sqlcot = conncot.confa.prepareStatement("insert into tbcotizacion (des_cot,fec_cot,id_cli_cot) values (?,?,?)");
        sqlcot.setString(1, des_cot);
        sqlcot.setString(2, fec_cot);
        if(id_cli == null){
         sqlcot.setString(3, null);
        }
        else{
        sqlcot.setInt(3, Integer.parseInt(id_cli));}
        sqlcot.executeUpdate();
        conncot.cerrar();
        
    } catch (Exception e) {
        System.out.println("Error al insertar cotizacion en clase cotizacion: "+e.getLocalizedMessage());
    }
}

//Metodo para consultar el codigo de la ultima cotizacion insertada en la tabla tbcotizacion en bd.
public void MtdTraerCodCotizacion(){
conncot.conectar();
    try {
        sqlcot = conncot.confa.prepareStatement("select * from tbcotizacion order by cod_cot desc limit 1");
        sqlcot.executeQuery();
        datoscot = sqlcot.getResultSet();
        conncot.cerrar();
        
    } catch (Exception e) {
        System.out.println("Error al traer codigo cotizacion en clase cotizacion: "+e.getLocalizedMessage());
    }
}

//Metodo para insertar registros en la tabla tbcotizacion_producto en bd.
public void MtdInsertarCotizacionProducto(int cot, int pro,double val_uni_pro, double pre_pro){
conncot.conectar();
    try {
        sqlcot = conncot.confa.prepareStatement("insert into tbcotizacion_producto values(?,?,?,?)");
        sqlcot.setInt(1, cot);
        sqlcot.setInt(2, pro);
        sqlcot.setDouble(3, val_uni_pro);
        sqlcot.setDouble(4, pre_pro);
        sqlcot.executeUpdate();
        conncot.cerrar();
    
    } catch (Exception e) {
         System.out.println("Error al insertar cotizacion_producto en clase cotizacion: "+e.getLocalizedMessage());

    }
}


//Metodo para actualizar el precio subtotal, precio total e  iva de la cotizacion en tabla tbcotizacion en bd.
public void MtdActualizarPrecioCotizacion(int cod_cot,double iva, double sub_tot_cot, double tot_cot){
    try {
        conncot.conectar();
        sqlcot = conncot.confa.prepareStatement("update tbcotizacion set iva_cot = ?, sub_tot_cot = ?, tot_cot = ? where cod_cot = ?");
        if(iva ==0){
        sqlcot.setDouble(1, iva);
        }else{sqlcot.setDouble(1, iva);
        }
        sqlcot.setDouble(2, sub_tot_cot);
        sqlcot.setDouble(3, tot_cot);
        sqlcot.setInt(4, cod_cot);
        sqlcot.executeUpdate();
        conncot.cerrar();
        
    } catch (Exception e) {
        System.out.println("Error al actualizar cotizacion en clase cotizacion: "+e.getLocalizedMessage());
    }
}

//Metodo para consultar todos los registros de la tabla tbcotizacion en bd.
public void MtdListarCotizacion(){
    try {
        conncot.conectar();
        sqlcot = conncot.confa.prepareStatement("select cod_cot, des_cot, fec_cot,id_cli_cot, nom_cli, sub_tot_cot, iva_cot, tot_cot from tbcotizacion as c inner join tbcliente as cli on c.id_cli_cot = cli.id_cli");
        sqlcot.executeQuery();
        datoscot = sqlcot.getResultSet();
        conncot.cerrar();
    } catch (Exception e) {
        System.out.println("Error al listar cotizacion en clase cotizacion: "+e.getLocalizedMessage());
    }
}
//Metodo para consultar los datos de la ultima cotizacion realizada.
public void MtdConsultarCotizacion(int cod_cot){
    try {
        conncot.conectar();
        sqlcot = conncot.confa.prepareStatement("select cod_cot,des_cot,fec_cot,iva_cot,sub_tot_cot,tot_cot,id_cli_cot,nom_cli,ape_cli,num_mov,num_fijo from tbtelefono_cliente as tc inner join tbcliente as c on tc.id_cli_tel = c.id_cli inner join tbcotizacion as ct on ct.id_cli_cot = c.id_cli where ct.cod_cot =?");
        sqlcot.setInt(1, cod_cot);
        sqlcot.executeQuery();
        datoscot = sqlcot.getResultSet();
        conncot.cerrar();
    } catch (Exception e) {
    }
}
//Metodo para consultar los datos de los produtos ligados a una cotizacion
public void MtdConsultarProducto_cotizacion(int cod_cot){
    try {
        conncot.conectar();
        sqlcot = conncot.confa.prepareStatement("select cod_pro_cp, des_tip_pto, can_pro, val_uni_pro,pre_pro_cp from tbcotizacion_producto as cp inner join tbproducto as p on cp.cod_pro_cp = p.cod_pro inner join tbtipoproducto as tp on cod_tip_pto_pro = tp.cod_tip_pto where cod_cot_cp =  ?");
        sqlcot.setInt(1, cod_cot);
        sqlcot.executeQuery();
        datoscot = sqlcot.getResultSet();
        conncot.cerrar();
    } catch (Exception e) {
        System.out.println("Error al consultar tabla producto_cotizacion en clase cotizacion: "+e.getLocalizedMessage());
    }
}

public void MtdConsultarProducto_despiece(int cod_pro){
    try {
        conncot.conectar();
        sqlcot = conncot.confa.prepareStatement("select cod_dpc_dp,des_dpc,can_dpc_dp,med_dpc_dp from tbdespiece_producto as dp inner join tbdespiece as d on dp.cod_dpc_dp = d.cod_dpc where dp.cod_pro_dp = ?");
        sqlcot.setInt(1, cod_pro);
        sqlcot.executeQuery();
        datoscot = sqlcot.getResultSet();
        conncot.cerrar();
              
    } catch (Exception e) {
         System.out.println("Error al consultar tabla despiece de JDialog MostrarDespiece    en clase cotizacion: "+e.getLocalizedMessage());
    }
}

public void MtdDatosCotizacion(int cod){
    try {
        conncot.conectar();
        sqlcot = conncot.confa.prepareStatement("select cod_cot,des_cot,fec_cot, sub_tot_cot,iva_cot,tot_cot,id_cli,nom_cli,ape_cli,dir_cli,ema_cli,num_fijo,num_mov,cod_pro,des_tip_pto,can_pro,val_uni_pro,pre_pro_cp from tbtelefono_cliente as tc inner join  tbcliente as cli on tc.id_cli_tel = cli.id_cli  inner  join tbcotizacion as c on c.id_cli_cot= cli.id_cli  inner join tbcotizacion_producto as cp on cp.cod_cot_cp = c.cod_cot inner join tbproducto as p on p.cod_pro = cp.cod_pro_cp inner join tbtipoproducto as tp on tp.cod_tip_pto = p.cod_tip_pto_pro where cod_cot = ?");
        sqlcot.setInt(1,cod);
        sqlcot.executeQuery();
        datoscot = sqlcot.getResultSet();
        conncot.cerrar();
        
    } catch (Exception e) {
        System.out.println("Error al consultar datos de la cotizacion en clase cotizacion:"+e.getLocalizedMessage() );
    }
    
    
}


}