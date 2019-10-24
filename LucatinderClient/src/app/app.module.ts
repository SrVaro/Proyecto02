import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProfileFormComponent } from './profile-form/profile-form.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileListComponent } from './profile-list/profile-list.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ContactsComponent } from './contacts/contacts.component';
import { DiscardsComponent } from './discards/discards.component';
import { MatchesComponent } from './matches/matches.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    ProfileFormComponent,
    LoginComponent,
    HomeComponent,
    ProfileListComponent,
    UserProfileComponent,
    ContactsComponent,
    DiscardsComponent,
    MatchesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
