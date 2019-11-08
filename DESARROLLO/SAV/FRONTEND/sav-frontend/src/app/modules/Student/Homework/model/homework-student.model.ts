export interface Homework {
  idTarea: number
  titulo: string
  cantidadPreguntas: string
  fechaLimite: string
  tiempoLimite: string
  contenido: string
}


export interface Questions {
  idTarea: number
  titulo: string
  contenido: string
  lsPreguntas: Question[]
}

export interface Question {
  idPregunta: number
  idRecurso: number
  descripcion: string
  urlImagen: string
  tipo: string
  alternativas: string[]
}

export interface SendAnswers {
  idTarea: number
  titulo: string
  idEstudiante: number
  contenido: string
  lsPreguntas: QuestionA[]
}

export interface QuestionA {
  idPregunta: number
  idRecurso: number
  descripcion: string
  urlImagen: string
  tipo: string
  alternativas: string[]
  respuestaEstudiante: string
}

export interface Answer {
  respuesta: string
}

export interface ConfirmationAnswer {
  confirmacion: boolean
}

export interface Results {
  nota: string
  totalPreguntas:number
  lsTiposResultados: Result[]
}

export interface Result {
  tipo: string
  porcentaje:number
  cantidad:number
}
