
import { Directive , HostBinding , HostListener , Output } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { EventEmitter } from '@angular/core';
import { FileHandel } from './_model/file-handel.model';

@Directive({
  selector: '[appDrag]'
})
export class DragDirective {


  @Output() files : EventEmitter<FileHandel> = new EventEmitter();

  @HostBinding("style.background") private background = "#eee";
  
  constructor(private sanitizer : DomSanitizer) { }

  @HostListener("dragover", ["$event"])
  public onDragOver(evt: DragEvent){
    evt.preventDefault();
    evt.stopPropagation();
    this.background ="#999";
  }

  @HostListener("dragleave", ["$event"])
  public onDragLeave(evt: DragEvent){
    evt.preventDefault();
    evt.stopPropagation();
    this.background ="#eee";
  }

  @HostListener("drop", ["$event"])
  public onDrop(evt: DragEvent){
    evt.preventDefault();
    evt.stopPropagation();
    this.background ="#eee";

    let fileHandle: FileHandel = null;

    const file = evt.dataTransfer.files[0];

    const url = this.sanitizer.bypassSecurityTrustUrl(window.URL.createObjectURL(file));
    let fileHandel: FileHandel
    fileHandel = {file, url};
    this.files.emit(fileHandel);
  }

}
