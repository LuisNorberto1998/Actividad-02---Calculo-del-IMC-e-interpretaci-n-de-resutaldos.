
package models;

public class ModelImc {
    
    private Double altura;
    private Double alturaMetros;
    private Double peso;
    private String sexo;
    private Double imc;
    private String imcTipo;
    private String Resultado;

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getAlturaMetros() {
        return alturaMetros;
    }

    public void setAlturaMetros(Double alturaMetros) {
        this.alturaMetros = alturaMetros;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getImc() {
        return imc;
    }

    public void setImc(Double imc) {
        this.imc = imc;
    }

    public String getImcTipo() {
        return imcTipo;
    }

    public void setImcTipo(String imcTipo) {
        this.imcTipo = imcTipo;
    }

    public String getResultado() {
        return Resultado;
    }

    public void setResultado(String Resultado) {
        this.Resultado = Resultado;
    }
}
