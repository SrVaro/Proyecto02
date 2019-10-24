import { Component, OnInit, Output, EventEmitter } from '@angular/core';
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
    this.profileService.login(form.value.name, form.value.pass).subscribe(
      result => {this.gotoHome();
                  console.log(form.value.name + form.value.pass)},
      error => { this.hasFailed = true }
      );
  }

  gotoHome(){
    this.router.navigate(['/home'])
  }
}
