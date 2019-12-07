
//Interfaces para la Autentificación

export interface Login {
  username:string
  password:string
}

export interface PayloadToken {
  student?: {
    id: number,
    codigoGrado: number,
    apellidoPaterno:string,
    nombre:string
    siglas:string
    seccion:string
    anio:string
  }
  teacher?:{
    id: number,
    apellidoPaterno:string,
    nombre:string
    siglas:string
  }
}
