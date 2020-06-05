export class Movie {
    id: number
    movieName: string
    storyLine: string
    cast: string
    rating: number
    imageurl: string
    status: string

    constructor() {
        this.id = 0
        this.movieName = ""
        this.storyLine = ""
        this.cast = ""
        this.imageurl = ""
        this.status = ""
        this.rating = 0
    }
}