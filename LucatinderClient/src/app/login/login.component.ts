import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  hasFailed: boolean;

  constructor(private router: Router, private profileService: ProfileService) {
    this.hasFailed = false;
  }

  login(form){
    this.profileService.login(form.value.name).subscribe(
      result => this.router.navigate(['/home']),
      error => { this.hasFailed = true }
      );
  }
}
