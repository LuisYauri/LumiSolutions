//Interfaces para la Autentificación

export interface Login {
  username: string
  password: string
}

export interface PayloadToken {
  sub: string
  student?: {
    id: number,
    codigoGrado: number,
    apellidoPaterno: string,
    nombre: string
    siglas: string
    seccion: string
    anio: string
  }
  teacher?: {
    id: number,
    apellidoPaterno: string,
    nombre: string
    siglas: string
  }
}

export interface PayloadDataToken {
  id:number
  username:string
  codigoGrado:number
  apellidoPaterno:string
  nombres:string
  siglas:string
  seccion:string
  anio:string
}
