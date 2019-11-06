
//Interfaces para la Autentificación

export interface Login {
  tipo: string
  usuario:string
  contrasenia:string
}

export interface PayloadToken {
  "identity": {
    idEstudiante: number,
    codigoGrado: number,
    apellidoPaterno:string,
    nombre:string
    siglas:string
  }
}
