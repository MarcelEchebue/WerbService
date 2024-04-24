<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class formulaire extends Model
{
    protected $fillable = [
        'nombre', 
        'apellido',
        'edad',
        'nombre_padre',
        'nombre_madre'// Asegúrate de agregar aquí todos los atributos que deseas permitir que se actualicen en masa.
        // Otros atributos aquí...
    ];
}
