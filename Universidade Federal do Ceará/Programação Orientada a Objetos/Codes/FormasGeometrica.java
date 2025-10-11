class FormaGeometrica{
    
    public void area(float x){}
    public void perimetro(float x){}
    
}

class Circulo extends FormaGeometrica{
    private float raio;
    static float PI = 3.14f;
    
    public void setRaio(float x){
        this.raio = x;
    }
    
    public void getRaio(){}
    
    
    public float area(){
        return (raio * raio) * PI;
    }
    
    public float perimetro(){
        return (PI * 2) * raio;
    }
    
    
}


class Triangulo extends FormaGeometrica{
    private float lado1;
    private float lado2;
    private float lado3;
    
    
    public void setLado1(float x){
        this.lado1 = x;
    }
    
    public void setLado2(float x){
        this.lado2 = x;
    }
    
    public void setLado3(float x){
        this.lado3 = x;
    }
    
    public void getLado1(){}
    public void getLado2(){}
    public void getLado3(){}
    
    
    public float area(){
        
        if((lado1 + lado2) < lado3 || (lado2 + lado3) < lado1 || (lado1 + lado3) < lado2){
            return 0;
        }else{
            float p = (lado1 + lado2 + lado3) / 2f;
            return (float) Math.sqrt(p * (p - lado1) * (p - lado2) * (p - lado3));
        }
    }
    
    public float perimetro(){
        if((lado1 + lado2) < lado3 || (lado1 + lado3) < lado2 || (lado3 + lado2) < lado1){
          return 0;
        }else{
          return lado1 + lado2 + lado3;  
        }
    }
    
}


class Quadrado extends FormaGeometrica{
    private float lado;
    
    
    public void setLado(float x){
    this.lado = x;
    }
    
    public void getLado(){}
    
    
    public float area(){
        return lado * lado;
    }
    
    public float perimetro(){
        return lado * 4;
    }
    
}