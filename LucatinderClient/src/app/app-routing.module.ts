import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProfileFormComponent } from './profile-form/profile-form.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { ContactsComponent } from './contacts/contacts.component';
import { DiscardsComponent } from './discards/discards.component';
import { MatchesComponent } from './matches/matches.component';


const routes: Routes = [
  // { path: 'kittys', component: KittyListComponent },
  { path: 'register', component: ProfileFormComponent },
  { path: 'login', component: LoginComponent },
  { path: 'home', component: HomeComponent},
  { path: 'profile', component: UserProfileComponent},
  { path: 'contacts', component: ContactsComponent},
  { path: 'discards', component: DiscardsComponent},
  { path: 'matches', component: MatchesComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
