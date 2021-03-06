/*
 * This java source file is generated by DAO4J v1.19
 * Generated on Tue Sep 16 23:32:33 CDT 2014
 * For more information, please contact b-i-d@163.com
 * Please check http://sourceforge.net/projects/dao4j/ for the latest version.
 */

package DTO;

/*
 * For Table alumno
 */
public class Alumno implements java.io.Serializable, Cloneable {
    

    /* matriculaA, PK */
    private long matriculaa;

    /* nombre */
    private String nombre;

    /* paterno */
    private String paterno;

    /* materno */
    private String materno;

    /* fechaN */
    private java.util.Date fechan;

    /* calle */
    private String calle;

    /* colonia */
    private String colonia;

    /* num */
    private int num;

    /* cp */
    private long cp;

    /* sexo */
    private String sexo;

    /* email */
    private String email;

    /* clave */
    private String clave;

    /* idCarrera */
    private int idcarrera;

    /* matriculaA, PK */
    public long getMatriculaa() {
        return matriculaa;
    }

    /* matriculaA, PK */
    public void setMatriculaa(long matriculaa) {
        this.matriculaa = matriculaa;
    }

    /* nombre */
    public String getNombre() {
        return nombre;
    }

    /* nombre */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /* paterno */
    public String getPaterno() {
        return paterno;
    }

    /* paterno */
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    /* materno */
    public String getMaterno() {
        return materno;
    }

    /* materno */
    public void setMaterno(String materno) {
        this.materno = materno;
    }

    /* fechaN */
    public java.util.Date getFechan() {
        return fechan;
    }

    /* fechaN */
    public void setFechan(java.util.Date fechan) {
        this.fechan = fechan;
    }

    /* calle */
    public String getCalle() {
        return calle;
    }

    /* calle */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /* colonia */
    public String getColonia() {
        return colonia;
    }

    /* colonia */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /* num */
    public int getNum() {
        return num;
    }

    /* num */
    public void setNum(int num) {
        this.num = num;
    }

    /* cp */
    public long getCp() {
        return cp;
    }

    /* cp */
    public void setCp(long cp) {
        this.cp = cp;
    }

    /* sexo */
    public String getSexo() {
        return sexo;
    }

    /* sexo */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /* email */
    public String getEmail() {
        return email;
    }

    /* email */
    public void setEmail(String email) {
        this.email = email;
    }

    /* clave */
    public String getClave() {
        return clave;
    }

    /* clave */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /* idCarrera */
    public int getIdcarrera() {
        return idcarrera;
    }

    /* idCarrera */
    public void setIdcarrera(int idcarrera) {
        this.idcarrera = idcarrera;
    }

    /* Indicates whether some other object is "equal to" this one. */
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Alumno))
            return false;

        Alumno bean = (Alumno) obj;

        if (this.matriculaa != bean.matriculaa)
            return false;

        if (this.nombre == null) {
            if (bean.nombre != null)
                return false;
        }
        else if (!this.nombre.equals(bean.nombre)) 
            return false;

        if (this.paterno == null) {
            if (bean.paterno != null)
                return false;
        }
        else if (!this.paterno.equals(bean.paterno)) 
            return false;

        if (this.materno == null) {
            if (bean.materno != null)
                return false;
        }
        else if (!this.materno.equals(bean.materno)) 
            return false;

        if (this.fechan == null) {
            if (bean.fechan != null)
                return false;
        }
        else if (!this.fechan.equals(bean.fechan)) 
            return false;

        if (this.calle == null) {
            if (bean.calle != null)
                return false;
        }
        else if (!this.calle.equals(bean.calle)) 
            return false;

        if (this.colonia == null) {
            if (bean.colonia != null)
                return false;
        }
        else if (!this.colonia.equals(bean.colonia)) 
            return false;

        if (this.num != bean.num)
            return false;

        if (this.cp != bean.cp)
            return false;

        if (this.sexo == null) {
            if (bean.sexo != null)
                return false;
        }
        else if (!this.sexo.equals(bean.sexo)) 
            return false;

        if (this.email == null) {
            if (bean.email != null)
                return false;
        }
        else if (!this.email.equals(bean.email)) 
            return false;

        if (this.clave == null) {
            if (bean.clave != null)
                return false;
        }
        else if (!this.clave.equals(bean.clave)) 
            return false;

        if (this.idcarrera != bean.idcarrera)
            return false;

        return true;
    }

    /* Creates and returns a copy of this object. */
    public Object clone()
    {
        Alumno bean = new Alumno();
        bean.matriculaa = this.matriculaa;
        bean.nombre = this.nombre;
        bean.paterno = this.paterno;
        bean.materno = this.materno;
        if (this.fechan != null)
            bean.fechan = (java.util.Date) this.fechan.clone();
        bean.calle = this.calle;
        bean.colonia = this.colonia;
        bean.num = this.num;
        bean.cp = this.cp;
        bean.sexo = this.sexo;
        bean.email = this.email;
        bean.clave = this.clave;
        bean.idcarrera = this.idcarrera;
        return bean;
    }

    /* Returns a string representation of the object. */
    public String toString() {
        String sep = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append(this.getClass().getName()).append(sep);
        sb.append("[").append("matriculaa").append(" = ").append(matriculaa).append("]").append(sep);
        sb.append("[").append("nombre").append(" = ").append(nombre).append("]").append(sep);
        sb.append("[").append("paterno").append(" = ").append(paterno).append("]").append(sep);
        sb.append("[").append("materno").append(" = ").append(materno).append("]").append(sep);
        sb.append("[").append("fechan").append(" = ").append(fechan).append("]").append(sep);
        sb.append("[").append("calle").append(" = ").append(calle).append("]").append(sep);
        sb.append("[").append("colonia").append(" = ").append(colonia).append("]").append(sep);
        sb.append("[").append("num").append(" = ").append(num).append("]").append(sep);
        sb.append("[").append("cp").append(" = ").append(cp).append("]").append(sep);
        sb.append("[").append("sexo").append(" = ").append(sexo).append("]").append(sep);
        sb.append("[").append("email").append(" = ").append(email).append("]").append(sep);
        sb.append("[").append("clave").append(" = ").append(clave).append("]").append(sep);
        sb.append("[").append("idcarrera").append(" = ").append(idcarrera).append("]").append(sep);
        return sb.toString();
    }
}