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
  lsPreguntas: QuestionA[]
}

export interface QuestionA {
  idPregunta: number
  idRecurso: number
  descripcion: string
  urlImagen: string
  tipo: string
  alternativas: string[]
  respuestaEstudiante: number
}

export interface Answer {
  respuesta: string
}

export interface ConfirmationAnswer {
  confirmacion: boolean
}
