<?php

namespace App\Enum;

enum EtatVente: string
{
    case COMPLETED = 'COMPLETED';
    case COLLECTED = 'COLLECTED';
    case PENDING = 'PENDING';
    case CANCELLED = 'CANCELLED';
}