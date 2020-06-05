import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from './model/User';
import { Injectable } from '@angular/core';

const httpOptions = {
  headers: new HttpHeaders({
    'Authorization': 'someToken'
  }),
  withCredentials: true
};

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  loginStatus: boolean
  currentUser: User

  constructor(public http: HttpClient) {
    this.loginStatus = false
  }

  signIn(user: User) {
    return this.http.post('http://172.18.218.111:8876/moviereview/signin', user, httpOptions)
  }

  signUp(user: User) {
    return this.http.post('http://172.18.218.111:8876/moviereview/signup', user, httpOptions)
  }

  signOut() {
    return this.http.post('http://172.18.218.111:8876/moviereview/signout', {}, httpOptions)
  }

}