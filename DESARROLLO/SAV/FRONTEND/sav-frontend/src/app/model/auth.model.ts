//Interfaces para la Autentificación

export interface Login {
  username: string
  password: string
}

export interface PayloadToken {
  sub: string
}

export interface PayloadDataToken {
  id: number
  username: string
  codigoGrado: number
  apellidoPaterno: string
  nombres: string
  siglas: string
  seccion: string
  anio: string
  tipoPersona: string
}

export interface AulaDataToken {
  idAula: number
  codigoGrado: number
  grupo: string
  anio: number
}
