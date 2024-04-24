<?php

namespace App\Http\Resources;

use Illuminate\Http\Request;
use Illuminate\Http\Resources\Json\JsonResource;

class formulaireResource extends JsonResource
{
    public function toArray($request)
    {
        return [
            'id' => $this->id,
            'nombre' => $this->nombre,
            'apellido' => $this->apellido,
            'edad' => $this->apellido,
            'nombre_padre' => $this->nombre_padre,
            'nombre_madre' => $this->nombre_madre,
            // Agrega más campos según sea necesario
        ];
    }
}
