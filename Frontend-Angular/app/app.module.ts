import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { Routes, RouterModule } from '@angular/router';
import { NavbarComponent } from './components/navbar/navbar.component';
import { MoviesComponent } from './components/movies/movies.component';
import { SignInComponent } from './components/sign-in/sign-in.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { SignUpComponent } from './components/sign-up/sign-up.component';
import { ReviewComponent } from './components/review/review.component';
import { MovieDetailComponent } from './movie-detail/movie-detail.component';
import { MyReviewsComponent } from './my-reviews/my-reviews.component';


const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'signin', component: SignInComponent },
  { path: 'signup', component: SignUpComponent },  
  { path: 'movies', component: MoviesComponent },
  { path: 'review/:id', component: ReviewComponent },
  { path: 'movie/detail/:id', component: MovieDetailComponent },
  { path: 'my-reviews', component: MyReviewsComponent }
];

@NgModule({
  declarations:
    [
      AppComponent,
      HomeComponent,
      MoviesComponent,
      NavbarComponent,
      SignInComponent,
      SignUpComponent, 
      ReviewComponent,     
      MovieDetailComponent, MyReviewsComponent
    ],
  imports:
    [
      BrowserModule,
      FormsModule,
      HttpClientModule,
      RouterModule.forRoot(appRoutes)
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
