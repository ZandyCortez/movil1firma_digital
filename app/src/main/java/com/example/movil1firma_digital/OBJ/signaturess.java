package com.example.movil1firma_digital.OBJ;

public class signaturess
{
    private String descripcion;
    private byte[] firma;
    private Integer id;

    public signaturess(Integer id,byte[] firma,String descripcion) {
        this.id = id;
        this.firma = firma;
        this.descripcion = descripcion;
    }

    public signaturess() {}

    public String getDescripcion() {return descripcion;}

    public void setDescripcion(String descripcion) {this.descripcion = descripcion;}

    public byte[] getFirma() {return firma;}

    public void setFirma(byte[] firma) {this.firma = firma;}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}
}
